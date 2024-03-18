package com.breezeeurobondfsm.features.stockAddCurrentStock.api

import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.location.model.ShopRevisitStatusRequest
import com.breezeeurobondfsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.breezeeurobondfsm.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.breezeeurobondfsm.features.stockAddCurrentStock.model.CurrentStockGetData
import com.breezeeurobondfsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}