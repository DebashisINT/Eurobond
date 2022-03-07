package com.eurobond.features.stockAddCurrentStock.api

import com.eurobond.base.BaseResponse
import com.eurobond.features.location.model.ShopRevisitStatusRequest
import com.eurobond.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.eurobond.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.eurobond.features.stockAddCurrentStock.model.CurrentStockGetData
import com.eurobond.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}