package com.eurobond.features.stockAddCurrentStock.api

import com.eurobond.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.eurobond.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}