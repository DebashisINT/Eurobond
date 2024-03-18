package com.breezeeurobondfsm.features.stockAddCurrentStock.api

import com.breezeeurobondfsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.breezeeurobondfsm.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}