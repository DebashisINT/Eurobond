package com.eurobond.features.location.ideallocapi

/**
 * Created by Saikat on 05-02-2019.
 */
object IdealLocationRepoProvider {
    fun provideIdealLocationRepository(): IdealLocationRepo {
        return IdealLocationRepo(IdealLocationApi.create())
    }
}