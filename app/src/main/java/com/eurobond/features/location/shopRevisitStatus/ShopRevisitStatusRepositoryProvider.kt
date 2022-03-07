package com.eurobond.features.location.shopRevisitStatus

import com.eurobond.features.location.shopdurationapi.ShopDurationApi
import com.eurobond.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}