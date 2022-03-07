package com.eurobond.features.location.shopRevisitStatus

import com.eurobond.base.BaseResponse
import com.eurobond.features.location.model.ShopDurationRequest
import com.eurobond.features.location.model.ShopRevisitStatusRequest
import io.reactivex.Observable

class ShopRevisitStatusRepository(val apiService : ShopRevisitStatusApi) {
    fun shopRevisitStatus(shopRevisitStatus: ShopRevisitStatusRequest?): Observable<BaseResponse> {
        return apiService.submShopRevisitStatus(shopRevisitStatus)
    }
}