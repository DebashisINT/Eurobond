package com.eurobond.features.stockCompetetorStock.api

import com.eurobond.base.BaseResponse
import com.eurobond.features.orderList.model.NewOrderListResponseModel
import com.eurobond.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.eurobond.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}