package com.breezeeurobondfsm.features.leaderboard

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.borax12.materialdaterangepicker.date.DatePickerDialog
import com.breezeeurobondfsm.R
import com.breezeeurobondfsm.app.types.TopBarConfig
import com.breezeeurobondfsm.app.utils.AppUtils
import com.breezeeurobondfsm.app.utils.FTStorageUtils
import com.breezeeurobondfsm.app.utils.Toaster
import com.breezeeurobondfsm.base.presentation.BaseFragment
import com.breezeeurobondfsm.features.contacts.CustomData
import com.breezeeurobondfsm.features.contacts.GenericDialog
import com.breezeeurobondfsm.features.dashboard.presentation.DashboardActivity
import com.pnikosis.materialishprogress.ProgressWheel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale


class LeaderBoardFrag : BaseFragment(), View.OnClickListener, DatePickerDialog.OnDateSetListener{
    private lateinit var constraintLayoutBTN: ConstraintLayout
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var main_const: ConstraintLayout
    private lateinit var bt_overall: TextView
    private lateinit var bt_own: TextView
    private lateinit var tv_nointernet: TextView
    private lateinit var iv_filter: ImageView
    private lateinit var rv_leaderboard: RecyclerView
    private lateinit var cardView_own: CardView
    private lateinit var first_half: ConstraintLayout
    private lateinit var own_part_back: ConstraintLayout
    private lateinit var progress_wheel: ProgressWheel
    private lateinit var mLeaderBoardData : ArrayList<LeaderBoardData>
    private lateinit var mFilterratingData : ArrayList<LeaderBoardData>
    private lateinit var mLeaderBoardAdapter : LeaderBoardAdapter
    private var filterDialog: Dialog? = null
    private lateinit var mContext: Context
    private var str_filterRatingID:String = ""
    private var str_filterBranchID:String = ""
    private var str_filterDurationID:String = ""
    private var startDate:String = ""
    private var endDate:String = ""
    private var flag:String = "M"
    private var ownclick:Boolean = false


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_leader_board, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        constraintLayoutBTN = view.findViewById(R.id.constraintLayoutBTN)
        progress_wheel = view.findViewById(R.id.progress_wheel_frag_leaderboard)
        constraintLayout = view.findViewById(R.id.constraintLayout)
        main_const = view.findViewById(R.id.main_const)
        bt_overall = view.findViewById(R.id.bt_overall)
        bt_own = view.findViewById(R.id.bt_own)
        iv_filter = view.findViewById(R.id.iv_filter)
        first_half = view.findViewById(R.id.first_half)
        own_part_back = view.findViewById(R.id.own_part_back)
        rv_leaderboard = view.findViewById(R.id.rv_leaderboard)
        cardView_own = view.findViewById(R.id.cardView_own)
        tv_nointernet = view.findViewById(R.id.tv_nointernet)

        if (AppUtils.isOnline(mContext)) {

            constraintLayout.visibility=View.VISIBLE
            tv_nointernet.visibility=View.INVISIBLE

            bt_overall.setOnClickListener(this)
            bt_own.setOnClickListener(this)
            iv_filter.setOnClickListener(this)

            bt_overall.setText("Overall")
            bt_own.setText("Own")
            bt_overall.setBackgroundResource(R.drawable.attached_image_rounded_bg)
            context?.getColor(R.color.white)?.let { bt_overall.setTextColor(it) }
            context?.getColor(R.color.black)?.let { bt_own.setTextColor(it) }
            rv_leaderboard.visibility = View.VISIBLE
            bt_own.setBackgroundResource(0)
            first_half.setBackgroundColor(0x00000000)

            mLeaderBoardData = ArrayList()
            mLeaderBoardAdapter = LeaderBoardAdapter(mLeaderBoardData)
            leaderboardScoreListItems()
            rv_leaderboard.layoutManager =
                LinearLayoutManager(context)
            rv_leaderboard.setHasFixedSize(true)
            rv_leaderboard.adapter = mLeaderBoardAdapter

            currentDate()
        }
        else{
            constraintLayout.visibility=View.INVISIBLE
            tv_nointernet.visibility=View.VISIBLE
        }

    }

    private fun currentDate() {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        val formattedDate = currentDate.format(formatter)
        println("Current Date (Formatted): $formattedDate")
        endDate=formattedDate
    }

    private fun leaderboardScoreListItems() {
        mLeaderBoardData.add(LeaderBoardData(1,"Papri Roy","7898616625","Developer","6201"))
        mLeaderBoardData.add(LeaderBoardData(2,"Ritesh Kumar","7898618625","Team Leader","6122"))
        mLeaderBoardData.add(LeaderBoardData(2,"Papri Roy","7898617625","Developer","6201"))
        mLeaderBoardData.add(LeaderBoardData(3,"Ritesh Kumar","7898316625","Team Leader","6122"))
        mLeaderBoardData.add(LeaderBoardData(4,"Papri Roy","7891616625","Developer","6201"))
        mLeaderBoardData.add(LeaderBoardData(5,"Ritesh Kumar","7898626625","Team Leader","6122"))
        mLeaderBoardData.add(LeaderBoardData(6,"Papri Roy","7898610625","Developer","6201"))
        mLeaderBoardData.add(LeaderBoardData(7,"Ritesh Kumar","7899616625","Team Leader","6122"))
        mLeaderBoardData.add(LeaderBoardData(8,"Papri Roy","7898676625","Developer","6201"))
        mLeaderBoardData.add(LeaderBoardData(9,"Ritesh Kumar","7898516625","Team Leader","6122"))

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LeaderBoardFrag().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.bt_overall ->{
                ownclick=false
                setToolbar()
                bt_overall.setBackgroundResource(R.drawable.attached_image_rounded_bg)
                bt_own.setBackgroundResource(0)
                first_half.setBackgroundColor(0x00000000)
                context?.getColor(R.color.white)?.let { bt_overall.setTextColor(it) }
                context?.getColor(R.color.black)?.let { bt_own.setTextColor(it) }
                rv_leaderboard.visibility=View.VISIBLE
                cardView_own.visibility=View.INVISIBLE
                own_part_back.visibility=View.INVISIBLE

                (mContext as DashboardActivity).setTopBarTitle("Leaderboard (TOP 10)")


            }
            R.id.bt_own ->{

                ownclick=true

                setToolbar()

                bt_own.setBackgroundResource(R.drawable.attached_image_rounded_bg)
                first_half.setBackgroundColor(Color.parseColor("#3d30d7"));
                own_part_back.setBackgroundResource(R.drawable.leaderbackground)
                bt_overall.setBackgroundResource(0)
                context?.getColor(R.color.white)?.let { bt_own.setTextColor(it) }
                context?.getColor(R.color.black)?.let { bt_overall.setTextColor(it) }
                rv_leaderboard.visibility=View.GONE
                cardView_own.visibility=View.VISIBLE
                own_part_back.visibility=View.VISIBLE

            }
            R.id.iv_filter ->{

                filterDialog = Dialog(mContext)
                filterDialog!!.setCancelable(false)
                filterDialog!!.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                filterDialog!!.setContentView(R.layout.filter_of_leaderboard)
                val tv_header = filterDialog!!.findViewById(R.id.tv_header) as TextView
                val ll_ratingbased = filterDialog!!.findViewById(R.id.ll_ratingbased) as LinearLayout
                val ll_branchFilter = filterDialog!!.findViewById(R.id.ll_branchFilter) as LinearLayout
                val ll_durationFilter = filterDialog!!.findViewById(R.id.ll_durationFilter) as LinearLayout
                val part_one_filter = filterDialog!!.findViewById(R.id.part_one_filter) as LinearLayout
                val part_two_filter = filterDialog!!.findViewById(R.id.part_two_filter) as LinearLayout
                val tv_ratingbased = filterDialog!!.findViewById(R.id.tv_ratingbased) as TextView
                val tv_branch = filterDialog!!.findViewById(R.id.tv_branch) as TextView
                val tv_duration = filterDialog!!.findViewById(R.id.tv_duration) as TextView
                val tv_filterDone = filterDialog!!.findViewById(R.id.tv_filterDone) as TextView
                val iv_close = filterDialog!!.findViewById(R.id.iv_close) as ImageView
                tv_header.text = "Filter"

                val window: Window = filterDialog?.getWindow()!!
                val wlp: WindowManager.LayoutParams = window.getAttributes()

                val params: WindowManager.LayoutParams =
                    filterDialog!!.getWindow()!!.getAttributes() // change this to your dialog.
                params.y = -440 // Here is the param to set your dialog position. Same with params.x
                filterDialog!!.getWindow()?.setAttributes(params)
                filterDialog!!.show()

                if (ownclick == true){
                    part_one_filter.visibility= View.GONE
                    part_two_filter.visibility= View.VISIBLE
                }

                iv_close.setOnClickListener {
                    filterDialog!!.dismiss()
                }
                tv_filterDone.setOnClickListener {
                    filterDialog!!.dismiss()
                }
                //activities filter
                ll_ratingbased.setOnClickListener {
                    var mFilterratingData = ArrayList<LeaderBoardFilterOnRatingData>()
                    mFilterratingData.add(LeaderBoardFilterOnRatingData(1,"Attendance"))
                    mFilterratingData.add(LeaderBoardFilterOnRatingData(2,"New Visit"))
                    mFilterratingData.add(LeaderBoardFilterOnRatingData(3,"Revisit"))
                    mFilterratingData.add(LeaderBoardFilterOnRatingData(4,"Order"))
                    mFilterratingData.add(LeaderBoardFilterOnRatingData(4,"Activities"))
                  if(mFilterratingData.size>0){
                        var genericL : ArrayList<CustomData> = ArrayList()
                        for(i in 0..mFilterratingData.size-1){
                            genericL.add(CustomData(mFilterratingData.get(i).id.toString(),mFilterratingData.get(i).name.toString()))
                        }
                        GenericDialog.newInstance("Activities",genericL as ArrayList<CustomData>){
                            str_filterRatingID = it.id
                            tv_ratingbased.setText(it.name)
                        }.show((mContext as DashboardActivity).supportFragmentManager, "")
                    }else{
                        Toaster.msgShort(mContext, "No Activities Found")
                    }
                }
                //branch filter
                ll_branchFilter.setOnClickListener {
                    var mFilterbranchData = ArrayList<LeaderBoardFilterOnBranchData>()
                    mFilterbranchData.add(LeaderBoardFilterOnBranchData(1,"HO"))
                    mFilterbranchData.add(LeaderBoardFilterOnBranchData(2,"CAPITAL ENGINEERING CONSULTANCY - CHENNAI"))
                    mFilterbranchData.add(LeaderBoardFilterOnBranchData(3,"Kolkata"))
                    mFilterbranchData.add(LeaderBoardFilterOnBranchData(4,"del"))
                    if(mFilterbranchData.size>0){
                        var genericL : ArrayList<CustomData> = ArrayList()
                        for(i in 0..mFilterbranchData.size-1){
                            genericL.add(CustomData(mFilterbranchData.get(i).id.toString(),mFilterbranchData.get(i).name.toString()))
                        }
                        GenericDialog.newInstance("Branch",genericL as ArrayList<CustomData>){
                            str_filterBranchID = it.id
                            tv_branch.setText(it.name)
                        }.show((mContext as DashboardActivity).supportFragmentManager, "")
                    }else{
                        Toaster.msgShort(mContext, "No Branch Found")
                    }
                }
                //duration filter
                ll_durationFilter.setOnClickListener {
                    var mFilterbranchData = ArrayList<LeaderBoardFilterOnDurationData>()
                    mFilterbranchData.add(LeaderBoardFilterOnDurationData(5,"MTD"))
                    mFilterbranchData.add(LeaderBoardFilterOnDurationData(5,"Overall"))
                    if(mFilterbranchData.size>0){
                        var genericL : ArrayList<CustomData> = ArrayList()
                        for(i in 0..mFilterbranchData.size-1){
                            genericL.add(CustomData(mFilterbranchData.get(i).id.toString(),mFilterbranchData.get(i).name.toString()))
                        }
                        GenericDialog.newInstance("Duration",genericL as ArrayList<CustomData>){
                            str_filterDurationID = it.id
                            tv_duration.setText(it.name)

                            if (it.name.equals("MTD")){
                                    flag = "M"
                            }
                            if (it.name.equals("Overall")){
                                    flag = "O"
                            }
                        }.show((mContext as DashboardActivity).supportFragmentManager, "")
                    }else{
                        Toaster.msgShort(mContext, "No Duration Found")
                    }
                   /*if(mFilterbranchData.size>0){
                        var genericL : ArrayList<CustomData> = ArrayList()
                        for(i in 0..mFilterbranchData.size-1){
                            genericL.add(CustomData(mFilterbranchData.get(i).id.toString(),mFilterbranchData.get(i).name.toString()))
                        }
                        GenericDialog.newInstance("Duration",genericL as ArrayList<CustomData>){
                            str_filterDurationID = it.id
                            tv_duration.setText(it.name)

                            if (it.name.equals("MTD")){
                                // Get current date
                                val calendar = Calendar.getInstance()
                                // Set day of month to 1 to get the first day of the current month
                                calendar[Calendar.DAY_OF_MONTH] = 1
                                // Get year and month
                                val year = calendar[Calendar.YEAR]
                                val month = calendar[Calendar.MONTH] + 1 // Note: January is 0
                                // Print the first date of the current month with year
                                val firstDateOfMonth = String.format("%04d/%02d/%02d", year, month, 1)
                                Log.d("FirstDateOfMonth", firstDateOfMonth)
                                startDate=firstDateOfMonth
                            }
                            if (it.name.equals("Specific date Range")){
                                val now = Calendar.getInstance(Locale.ENGLISH)
                                val dpd = DatePickerDialog.newInstance(
                                    this,
                                    now.get(Calendar.YEAR),
                                    now.get(Calendar.MONTH),
                                    now.get(Calendar.DAY_OF_MONTH)
                                )
                               // dpd.isAutoHighlight = mAutoHighlight
                                dpd.maxDate = Calendar.getInstance(Locale.ENGLISH)
                                dpd.show((context as Activity).fragmentManager, "Datepickerdialog")
                            }
                        }.show((mContext as DashboardActivity).supportFragmentManager, "")
                    }else{
                        Toaster.msgShort(mContext, "No Type Found")
                    }*/
                }

            }

        }

    }

    override fun onDateSet(
        datePickerDialog: DatePickerDialog,
        year: Int,
        monthOfYear: Int,
        dayOfMonth: Int,
        yearEnd: Int,
        monthOfYearEnd: Int,
        dayOfMonthEnd: Int
    ) {

        datePickerDialog.maxDate = Calendar.getInstance(Locale.ENGLISH)
        var monthOfYear = monthOfYear
        var monthOfYearEnd = monthOfYearEnd
        var day = "" + dayOfMonth
        var dayEnd = "" + dayOfMonthEnd
        if (dayOfMonth < 10)
            day = "0" + dayOfMonth
        if (dayOfMonthEnd < 10)
            dayEnd = "0" + dayOfMonthEnd
        var fronString: String = day + "-" + FTStorageUtils.formatMonth((monthOfYear + 1).toString() + "") + "-" + year
        var endString: String = dayEnd + "-" + FTStorageUtils.formatMonth((monthOfYearEnd + 1).toString() + "") + "-" + yearEnd
        if (AppUtils.getStrinTODate(endString).before(AppUtils.getStrinTODate(fronString))) {
            (mContext as DashboardActivity).showSnackMessage("Your end date is before start date.")
            return
        }

        Log.d("fromdateofmoth", fronString)
        Log.d("todateofmonth", endString)

    }

    fun setToolbar(){
        if (!ownclick) {
            (mContext as DashboardActivity).setTopBarTitle("Leaderboard ( TOP 10 )")
            (mContext as DashboardActivity).setTopBarVisibility(TopBarConfig.LEADERBOARD)
        }else{
            (mContext as DashboardActivity).setTopBarTitle("Leaderboard ( Me )")
            (mContext as DashboardActivity).setTopBarVisibility(TopBarConfig.LEADERBOARD_OWN)

        }
    }
}