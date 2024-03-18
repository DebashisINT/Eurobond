package com.breezeeurobondfsm.features.location.api

import com.breezeeurobondfsm.features.location.shopdurationapi.ShopDurationApi
import com.breezeeurobondfsm.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}