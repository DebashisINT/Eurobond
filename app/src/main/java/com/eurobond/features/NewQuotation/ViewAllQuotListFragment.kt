package com.eurobond.features.NewQuotation

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.eurobond.CustomStatic
import com.eurobond.R
import com.eurobond.app.NetworkConstant
import com.eurobond.app.types.FragType
import com.eurobond.app.utils.AppUtils
import com.eurobond.app.utils.Toaster
import com.eurobond.base.BaseResponse
import com.eurobond.base.presentation.BaseActivity
import com.eurobond.base.presentation.BaseFragment
import com.eurobond.features.NewQuotation.adapter.ViewAllQuotViewAdapter
import com.eurobond.features.NewQuotation.api.GetQuotRegProvider
import com.eurobond.features.NewQuotation.model.ViewDetailsQuotResponse
import com.eurobond.features.NewQuotation.model.ViewQuotResponse
import com.eurobond.features.NewQuotation.model.shop_wise_quotation_list
import com.eurobond.features.dashboard.presentation.DashboardActivity
import com.eurobond.features.member.model.TeamShopListDataModel
import com.eurobond.widgets.AppCustomTextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import com.pnikosis.materialishprogress.ProgressWheel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class ViewAllQuotListFragment : BaseFragment(), View.OnClickListener {

    private lateinit var mContext: Context
    var viewAllQuotRecyclerViewAdapter: ViewAllQuotViewAdapter?=null
    private lateinit var quot_list_rv: RecyclerView
    lateinit var no_quot_tv: AppCustomTextView
    lateinit var progress_wheel: ProgressWheel
    lateinit var shop_IV: ImageView
    lateinit var myshop_name_TV: AppCustomTextView
    lateinit var myshop_address_TV: AppCustomTextView
    lateinit var tv_contact_number: AppCustomTextView
    lateinit var add_quot_tv: FloatingActionButton
    var i: Int = 0
    var addedQuotList:ArrayList<shop_wise_quotation_list> = ArrayList()

    lateinit var simpleDialog: Dialog
    lateinit var addQuotEditResult: ViewDetailsQuotResponse

    companion object {
        var shop_id: String = ""
        var shop_name: String? = null
        var shop_contact_number: String? = null
        var address: String? = null
        var obj = TeamShopListDataModel()
        fun getInstance(shopObj: Any?): ViewAllQuotListFragment {
            val mQuotListFragment = ViewAllQuotListFragment()
            if (!TextUtils.isEmpty(shopObj.toString())) {
                obj = shopObj as TeamShopListDataModel
                shop_id = obj!!.shop_id.toString()
                shop_name = obj!!.shop_name
                shop_contact_number = obj!!.shop_contact
                address = obj!!.shop_address
            }
            return mQuotListFragment
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.frag_view_all_quot_list, container, false)
        initView(view)

        if(AppUtils.isOnline(mContext)){
            quotListCall(shop_id)
        }
        else{
            Toaster.msgShort(mContext, "No Internet connection")
        }

        return view
    }



    private fun initView(view: View) {
        quot_list_rv = view.findViewById(R.id.quot_list_rv)
        progress_wheel = view.findViewById(R.id.progress_wheel)
        no_quot_tv = view.findViewById(R.id.no_quot_tv)
        shop_IV = view.findViewById(R.id.shop_IV)
        myshop_name_TV = view.findViewById(R.id.myshop_name_TV)
        myshop_address_TV = view.findViewById(R.id.myshop_address_TV)
        tv_contact_number = view.findViewById(R.id.tv_contact_number)
        add_quot_tv = view.findViewById(R.id.add_quot_tv)
        setData()
        add_quot_tv.setOnClickListener(this)

        CustomStatic.IsNewQuotEdit=false

    }


    private fun setData() {
        progress_wheel.stopSpinning()
        myshop_address_TV.text = address
        myshop_name_TV.text = shop_name
        tv_contact_number.text = shop_contact_number
        val drawable = TextDrawable.builder()
                .buildRoundRect(shop_name!!.toUpperCase().take(1), ColorGenerator.MATERIAL.randomColor, 120)
        shop_IV.setImageDrawable(drawable)
    }

    override fun onClick(p0: View?) {
        i = 0
        when (p0?.id) {
            R.id.add_quot_tv -> {
                (mContext as DashboardActivity).loadFragment(FragType.AddQuotFormFragment, true, obj)
            }
        }
    }


    private fun quotListCall(shopId: String) {
        try{
            progress_wheel.spin()
            val repository = GetQuotRegProvider.provideSaveButton()
            BaseActivity.compositeDisposable.add(
                    repository.viewQuot(shopId)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result ->
                                val addQuotResult = result as ViewQuotResponse
                                progress_wheel.stopSpinning()
                                if (addQuotResult!!.status == NetworkConstant.SUCCESS) {
                                    if (addQuotResult!!.shop_wise_quotation_list!!.size > 0) {
                                        no_quot_tv.visibility = View.GONE
                                        addedQuotList.clear()
                                        addedQuotList.addAll(addQuotResult!!.shop_wise_quotation_list!!)
                                        setAdapter()
                                    }

                                } else {
                                    no_quot_tv.visibility = View.VISIBLE
//                                    (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                                }
                                BaseActivity.isApiInitiated = false
                            }, { error ->
                                (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                                progress_wheel.stopSpinning()
                                BaseActivity.isApiInitiated = false
                                if (error != null) {
                                }
                            })
            )
        }catch (ex: Exception){
            ex.printStackTrace()
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
            progress_wheel.stopSpinning()
        }

    }

    private fun setAdapter() {
        viewAllQuotRecyclerViewAdapter = ViewAllQuotViewAdapter(mContext, addedQuotList, object : ViewAllQuotViewAdapter.OnClickListener {
            override fun onView(adapterPosition: Int, QuotId: String) {
                (mContext as DashboardActivity).loadFragment(FragType.ViewDetailsQuotFragment, true, QuotId)
            }

            override fun onShare(adapterPosition: Int) {
                getDtlsBeforePDF(addedQuotList.get(adapterPosition))
            }

            override fun onDelete(adapterPosition: Int, QuotId: String) {
                simpleDialog = Dialog(mContext)
                simpleDialog.setCancelable(false)
                simpleDialog.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                simpleDialog.setContentView(R.layout.dialog_yes_no)
                val dialogHeader = simpleDialog.findViewById(R.id.dialog_yes_no_headerTV) as AppCustomTextView
                val dialogBody = simpleDialog.findViewById(R.id.dialog_cancel_order_header_TV) as AppCustomTextView
                val btn_no = simpleDialog.findViewById(R.id.tv_dialog_yes_no_no) as AppCustomTextView
                val btn_yes = simpleDialog.findViewById(R.id.tv_dialog_yes_no_yes) as AppCustomTextView

                dialogHeader.text = AppUtils.hiFirstNameText() + "!"
                dialogBody.text = "Do you want to delete this Quotation?..."

                btn_yes.setOnClickListener({ view ->
                    deleteQuot(QuotId)
                })
                btn_no.setOnClickListener({ view ->
                    simpleDialog.cancel()
                })
                simpleDialog.show()

            }

        })
        quot_list_rv.adapter=viewAllQuotRecyclerViewAdapter
    }

    private fun deleteQuot(quotId: String) {
        try{
            progress_wheel.spin()
            val repository = GetQuotRegProvider.provideSaveButton()
            BaseActivity.compositeDisposable.add(
                    repository.delQuot(quotId)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result ->
                                val delQuotResult = result as BaseResponse
                                progress_wheel.stopSpinning()
                                if (delQuotResult!!.status == NetworkConstant.SUCCESS) {
                                    (mContext as DashboardActivity).showSnackMessage(delQuotResult.message!!)
                                    simpleDialog.cancel()
                                    updateView()

                                } else {
                                    (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                                }
                                BaseActivity.isApiInitiated = false
                            }, { error ->
                                (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                                progress_wheel.stopSpinning()
                                BaseActivity.isApiInitiated = false
                                if (error != null) {
                                }
                            })
            )
        }catch (ex: Exception){
            ex.printStackTrace()
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
            progress_wheel.stopSpinning()
        }

    }

    private fun getDtlsBeforePDF(obj: shop_wise_quotation_list){
        try{
            progress_wheel.spin()
            val repository = GetQuotRegProvider.provideSaveButton()
            BaseActivity.compositeDisposable.add(
                    repository.viewDetailsQuot(obj.quotation_number!!)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result ->
                                val addQuotResult = result as ViewDetailsQuotResponse
                                addQuotEditResult = addQuotResult
                                progress_wheel.stopSpinning()
                                if (addQuotResult!!.status == NetworkConstant.SUCCESS) {
                                    saveDataAsPdf(addQuotEditResult)
                                } else {
                                    (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                                }
                                BaseActivity.isApiInitiated = false
                            }, { error ->
                                (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                                progress_wheel.stopSpinning()
                                BaseActivity.isApiInitiated = false
                                if (error != null) {
                                }
                            })
            )
        }catch (ex: Exception){
            ex.printStackTrace()
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
            progress_wheel.stopSpinning()
        }

    }

    private fun saveDataAsPdf(addQuotEditResult: ViewDetailsQuotResponse) {
        var document: Document = Document()
        val time = System.currentTimeMillis()
        //val fileName = "QUTO_" +  "_" + time
        var fileName = addQuotEditResult.quotation_number!!.toUpperCase() +  "_" + time
        fileName=fileName.replace("/","_")
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()+"/QUTO/"

        val dir = File(path)
        if (!dir.exists()) {
            dir.mkdirs()
        }

        try{
            PdfWriter.getInstance(document, FileOutputStream(path + fileName + ".pdf"))
            document.open()

            var font: Font = Font(Font.FontFamily.HELVETICA, 10f, Font.BOLD)
            var font1: Font = Font(Font.FontFamily.HELVETICA, 8f, Font.NORMAL)


            //image add
            val bm: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_logo)
            val bitmap = Bitmap.createScaledBitmap(bm, 50, 50, true);
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            var img: Image? = null
            val byteArray: ByteArray = stream.toByteArray()
            try {
                img = Image.getInstance(byteArray)
                img.alignment=Image.ALIGN_RIGHT
            } catch (e: BadElementException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            document.add(img)


            //var quotDate = AppUtils.getFormatedDateNew(addQuotEditResult.quotation_date_selection!!.replace("12:00:00 AM",""),"mm-dd-yyyy","dd-mm-yyyy")

            val dateLine = Paragraph("DATE: " +addQuotEditResult.quotation_date_selection!! +
                    "                                                              " + addQuotEditResult.quotation_number, font)
            dateLine.alignment = Element.ALIGN_LEFT
            dateLine.spacingAfter = 5f
            document.add(dateLine)


            val toLine = Paragraph("To,", font)
            toLine.alignment = Element.ALIGN_LEFT
            toLine.spacingAfter = 5f
            document.add(toLine)

            val cusName = Paragraph(addQuotEditResult.shop_name, font)
            cusName.alignment = Element.ALIGN_LEFT
            cusName.spacingAfter = 5f
            document.add(cusName)

            val cusAddress = Paragraph("customer Address:" + addQuotEditResult.shop_addr, font)
            cusAddress.alignment = Element.ALIGN_LEFT
            cusAddress.spacingAfter = 5f
            document.add(cusAddress)

//            val cusemail = Paragraph("Email : " + addQuotEditResult.shop_email, font)
//            cusemail.alignment = Element.ALIGN_LEFT
//            cusemail.spacingAfter = 5f
//            document.add(cusemail)
            val cusemail = Chunk("Email : " +  addQuotEditResult.shop_email, font)
            cusemail.setUnderline(0.1f, -2f) //0.1 thick, -2 y-location
            document.add(cusemail)
            val cusowner = Paragraph("Kind Attn. " + addQuotEditResult.shop_owner_name +"  "+ "(Mob.No.  " + addQuotEditResult.shop_phone_no +  ")", font)
            cusowner.alignment = Element.ALIGN_LEFT
            cusowner.spacingAfter = 5f
            document.add(cusowner)

            val sub = Paragraph("Sub :-Quotation For Eurobond-ALUMINIUM COMPOSITE PANEL", font)
            sub.alignment = Element.ALIGN_LEFT
            sub.spacingAfter = 10f
            document.add(sub)

            val body = Paragraph("\nSir,\n" +
                    "In reference to the discusssion held with you regarding the said subject,we are please to quote our most " +
                    "preferred rates & others terms and condition for the same as follows.\n", font1)
            body.alignment = Element.ALIGN_LEFT
            body.spacingAfter = 15f
            document.add(body)

            // table header
            var tableHeader: PdfPTable = PdfPTable(4)
            tableHeader.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER)
            tableHeader.addCell("Sr. No.")
            tableHeader.addCell("Description.")
            tableHeader.addCell("Rate/Sq.Mtr (INR)")
            tableHeader.addCell("Rate/Sq.Ft (INR)")
            document.add(tableHeader)

            //table body
            var srNo:String=""
            var desc:String=""
            var rateSqFt:String=""
            var rateSqMtr:String=""
            var obj=addQuotEditResult.quotation_product_details_list
            for (i in 0..obj!!.size-1) {
                srNo= (i+1).toString()
                desc=obj!!.get(i).product_name.toString() + "\n\n"+ "Color Code : "+obj.get(i).color_name
                rateSqFt="INR - "+obj!!.get(i).rate_sqft.toString()
                rateSqMtr="INR - "+obj!!.get(i).rate_sqmtr.toString()

                val tableRows = PdfPTable(4)
                tableRows.defaultCell.horizontalAlignment = Element.ALIGN_CENTER
                tableRows.addCell(srNo)
                tableRows.addCell(desc)
                tableRows.addCell(rateSqMtr)
                tableRows.addCell(rateSqFt)
                document.add(tableRows)

                document.add(Paragraph())
            }



            val terms = Paragraph("\nTerms & Conditions:                                                                                                  ", font)
            terms.alignment = Element.ALIGN_LEFT
            terms.spacingAfter = 5f
            document.add(terms)



            val taxs = Paragraph("Taxs                                    :     " + addQuotEditResult.taxes, font1)
            taxs.alignment = Element.ALIGN_LEFT
            taxs.spacingAfter = 5f
            document.add(taxs)


            val freight = Paragraph("Freight                                 :     " + addQuotEditResult.Freight, font1)
            freight.alignment = Element.ALIGN_LEFT
            freight.spacingAfter = 5f
            document.add(freight)


            val delivery = Paragraph("Delivery Time                      :     " + addQuotEditResult.delivery_time, font1)
            delivery.alignment = Element.ALIGN_LEFT
            delivery.spacingAfter = 5f
            document.add(delivery)


            val payment = Paragraph("Payment                              :     " + addQuotEditResult.payment, font1)
            payment.alignment = Element.ALIGN_LEFT
            payment.spacingAfter = 5f
            document.add(payment)

            val validity = Paragraph("Validity                                :     " + addQuotEditResult.validity, font1)
            validity.alignment = Element.ALIGN_LEFT
            validity.spacingAfter = 5f
            document.add(validity)

            val billing = Paragraph("Billing                                  :     " + addQuotEditResult.billing, font1)
            billing.alignment = Element.ALIGN_LEFT
            billing.spacingAfter = 5f
            document.add(billing)

            val product_tolerance_of_thickness = Paragraph("Product Tolerance of Thickness          :     " + addQuotEditResult.product_tolerance_of_thickness, font1)
            product_tolerance_of_thickness.alignment = Element.ALIGN_LEFT
            product_tolerance_of_thickness.spacingAfter = 5f
            document.add(product_tolerance_of_thickness)

            val product_tolerance_of_coating = Paragraph("Tolerance of Coating Thickness          :     " + addQuotEditResult.tolerance_of_coating_thickness, font1)
            product_tolerance_of_coating.alignment = Element.ALIGN_LEFT
            product_tolerance_of_coating.spacingAfter = 10f
            document.add(product_tolerance_of_coating)

            val end = Paragraph("Anticipating healthy business relation with your esteemed organization.", font1)
            end.alignment = Element.ALIGN_LEFT
            end.spacingAfter = 20f
            document.add(end)

            val thanks = Paragraph("\nThanks&Regards,", font)
            thanks.alignment = Element.ALIGN_LEFT
            thanks.spacingAfter = 5f
            document.add(thanks)

            val companyName = Paragraph("EURO PANEL PRODUCTS PVT LTD", font)
            companyName.alignment = Element.ALIGN_LEFT
            companyName.spacingAfter = 5f
            document.add(companyName)

            val salesmanName = Paragraph(addQuotEditResult.salesman_name, font)
            salesmanName.alignment = Element.ALIGN_LEFT
            salesmanName.spacingAfter = 5f
            document.add(salesmanName)

            val salesmanDes = Paragraph(addQuotEditResult.salesman_designation, font)
            salesmanDes.alignment = Element.ALIGN_LEFT
            salesmanDes.spacingAfter = 5f
            document.add(salesmanDes)

            val salesmanphone = Paragraph(addQuotEditResult.salesman_phone_no, font)
            salesmanphone.alignment = Element.ALIGN_LEFT
            salesmanphone.spacingAfter =  5f
            document.add(salesmanphone)

            val salesmanemail = Paragraph(addQuotEditResult.salesman_email, font)
            salesmanemail.alignment = Element.ALIGN_LEFT
            salesmanemail.spacingAfter =  5f
            document.add(salesmanemail)


            val euroHead = Paragraph("\nEURO PANEL PRODUCTS PVT. LTD.", font)
            euroHead.alignment = Element.ALIGN_LEFT
            euroHead.spacingAfter = 5f
            document.add(euroHead)

            //strip_line//bar//ics
            val bm1: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ics)
            val bitmap1 = Bitmap.createScaledBitmap(bm1, 50, 50, true)
            val stream1 = ByteArrayOutputStream()
            bitmap1.compress(Bitmap.CompressFormat.PNG, 100, stream1)
            var img1: Image? = null
            val byteArray1: ByteArray = stream1.toByteArray()
            try {
                img1 = Image.getInstance(byteArray1)
                img1.alignment=Image.ALIGN_LEFT
            } catch (e: BadElementException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
//            document.add(img1)

            val bm2: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.bar)
            val bitmap2 = Bitmap.createScaledBitmap(bm2, 50, 50, true)
            val stream2 = ByteArrayOutputStream()
            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, stream2)
            var img2: Image? = null
            val byteArray2: ByteArray = stream2.toByteArray()
            try {
                img2 = Image.getInstance(byteArray2)
            } catch (e: BadElementException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
//            document.add(img2)


            val companydel = Paragraph("Regd.Off: 702,Aravali Business Centre,Ramadas Sutrale Road,Borivali(West),Mumbai-400 092." +
                    "Factory: Survey No.124/4,Manekpur,Sanjan,Khattalwada,Taluka- Umbergaon,Dist.Valsad,Gujarat - 396120" +
                    "T: +91-22-29686500(30 lines) +91-7666625999 - E: sale@eurobondacp.com + W: www.eurobondacp.com + CIN: U28931MH2013PTC251176" +
                    "", font1)
            companydel.alignment = Element.ALIGN_RIGHT
            companydel.spacingAfter = 10f
            //document.add(img1)
            //document.add(img2)
            //img2!!.alignment=Image.ALIGN_CENTER
            //document.add(companydel)


           val tablee = PdfPTable(1)
            tablee.widthPercentage = 100f
            var cell = PdfPCell()
            var p = Paragraph()
            p.alignment=Element.ALIGN_LEFT
            img1!!.scalePercent(50f)
            p.add(Chunk(img1, 0f, 0f, true))
            //p.add(Chunk(img2, 0f, 0f, true))
            p.add(companydel)
            cell.addElement(p)
            cell.backgroundColor= BaseColor(0, 0, 0,0)
            cell.borderColor=BaseColor(0, 0, 0,0)

            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT)
            tablee.addCell(cell)
            document.add(tablee)



            val bm3: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.strip_line)
            val bitmap3 = Bitmap.createScaledBitmap(bm3, 550, 30, true)
            val stream3 = ByteArrayOutputStream()
            bitmap3.compress(Bitmap.CompressFormat.PNG, 100, stream3)
            var img3: Image? = null
            val byteArray3: ByteArray = stream3.toByteArray()
            try {
                img3 = Image.getInstance(byteArray3)
            } catch (e: BadElementException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            document.add(img3)


            document.close()


            var sendingPath=path+fileName+".pdf"
            if (!TextUtils.isEmpty(sendingPath)) {
                try {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    val fileUrl = Uri.parse(sendingPath)
                    val file = File(fileUrl.path)
                    val uri: Uri = FileProvider.getUriForFile(mContext, context!!.applicationContext.packageName.toString() + ".provider", file)
                    shareIntent.type = "image/png"
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
                    startActivity(Intent.createChooser(shareIntent, "Share pdf using"))
                } catch (e: Exception) {
                    e.printStackTrace()
                    (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                }
            }

        }catch (ex: Exception){
            ex.printStackTrace()
            Toaster.msgShort(mContext,ex.message.toString())
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
        }

    }

    fun updateView(){
        quotListCall(shop_id)
    }
}