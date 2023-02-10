package com.eurobond.features.location.api

import com.eurobond.features.location.shopdurationapi.ShopDurationApi
import com.eurobond.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}