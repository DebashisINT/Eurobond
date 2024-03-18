package com.breezeeurobondfsm.features.location.shopRevisitStatus

import com.breezeeurobondfsm.features.location.shopdurationapi.ShopDurationApi
import com.breezeeurobondfsm.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}