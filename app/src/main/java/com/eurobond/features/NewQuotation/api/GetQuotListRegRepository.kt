package com.eurobond.features.NewQuotation.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.eurobond.app.FileUtils
import com.eurobond.base.BaseResponse
import com.eurobond.features.NewQuotation.model.*
import com.eurobond.features.addshop.model.AddShopRequestData
import com.eurobond.features.addshop.model.AddShopResponse
import com.eurobond.features.login.model.userconfig.UserConfigResponseModel
import com.eurobond.features.myjobs.model.WIPImageSubmit
import com.eurobond.features.photoReg.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class GetQuotListRegRepository(val apiService : GetQutoListApi) {

    fun addQuot(shop: AddQuotRequestData): Observable<BaseResponse> {
        return apiService.getAddQuot(shop)
    }

    fun viewQuot(shopId: String): Observable<ViewQuotResponse> {
        return apiService.getQuotList(shopId)
    }

    fun viewDetailsQuot(quotId: String): Observable<ViewDetailsQuotResponse> {
        return apiService.getQuotDetailsList(quotId)
    }

    fun delQuot(quotId: String): Observable<BaseResponse>{
        return apiService.QuotDel(quotId)
    }

    fun editQuot(shop: EditQuotRequestData): Observable<BaseResponse> {
        return apiService.editQuot(shop)
    }


}