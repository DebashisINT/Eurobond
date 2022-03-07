package com.eurobond.features.dashboard.presentation.api.dayStartEnd

import com.eurobond.app.Pref
import com.eurobond.base.BaseResponse
import com.eurobond.features.dashboard.presentation.model.DaystartDayendRequest
import com.eurobond.features.dashboard.presentation.model.StatusDayStartEnd
import com.eurobond.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.eurobond.features.stockCompetetorStock.api.AddCompStockApi
import io.reactivex.Observable

class DayStartEndRepository (val apiService: DayStartEndApi){
    fun dayStart(daystartDayendRequest: DaystartDayendRequest): Observable<BaseResponse> {
        return apiService.submitDayStartEnd(daystartDayendRequest)
    }

    fun dayStartEndStatus(date:String): Observable<StatusDayStartEnd> {
        return apiService.statusDayStartEnd(Pref.session_token!!, Pref.user_id!!,date)
    }


}