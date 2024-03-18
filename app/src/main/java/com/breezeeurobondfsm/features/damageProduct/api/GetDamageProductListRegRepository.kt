package com.breezeeurobondfsm.features.damageProduct.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.breezeeurobondfsm.app.FileUtils
import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.NewQuotation.model.*
import com.breezeeurobondfsm.features.addshop.model.AddShopRequestData
import com.breezeeurobondfsm.features.addshop.model.AddShopResponse
import com.breezeeurobondfsm.features.damageProduct.model.DamageProductResponseModel
import com.breezeeurobondfsm.features.damageProduct.model.delBreakageReq
import com.breezeeurobondfsm.features.damageProduct.model.viewAllBreakageReq
import com.breezeeurobondfsm.features.login.model.userconfig.UserConfigResponseModel
import com.breezeeurobondfsm.features.myjobs.model.WIPImageSubmit
import com.breezeeurobondfsm.features.photoReg.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class GetDamageProductListRegRepository(val apiService : GetDamageProductListApi) {

    fun viewBreakage(req: viewAllBreakageReq): Observable<DamageProductResponseModel> {
        return apiService.viewBreakage(req)
    }

    fun delBreakage(req: delBreakageReq): Observable<BaseResponse>{
        return apiService.BreakageDel(req.user_id!!,req.breakage_number!!,req.session_token!!)
    }

}