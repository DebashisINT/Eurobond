package com.eurobond.features.location.api

import com.eurobond.features.location.shopdurationapi.ShopDurationApi
import com.eurobond.features.location.shopdurationapi.ShopDurationRepository

/**
 * Created by Saikat on 17-Aug-20.
 */
object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}