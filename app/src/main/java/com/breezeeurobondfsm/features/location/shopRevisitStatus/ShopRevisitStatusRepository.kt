package com.breezeeurobondfsm.features.location.shopRevisitStatus

import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.location.model.ShopDurationRequest
import com.breezeeurobondfsm.features.location.model.ShopRevisitStatusRequest
import io.reactivex.Observable

class ShopRevisitStatusRepository(val apiService : ShopRevisitStatusApi) {
    fun shopRevisitStatus(shopRevisitStatus: ShopRevisitStatusRequest?): Observable<BaseResponse> {
        return apiService.submShopRevisitStatus(shopRevisitStatus)
    }
}