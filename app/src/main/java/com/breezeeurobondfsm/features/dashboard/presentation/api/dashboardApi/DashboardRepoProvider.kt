package com.breezeeurobondfsm.features.dashboard.presentation.api.dashboardApi

import com.breezeeurobondfsm.features.login.api.LoginApi
import com.breezeeurobondfsm.features.login.api.LoginRepository

/**
 * Created by Saikat on 26-Jun-20.
 */
object DashboardRepoProvider {
    fun provideDashboardImgRepository(): DashboardRepo {
        return DashboardRepo(DashboardApi.img())
    }

    fun provideDashboardRepository(): DashboardRepo {
        return DashboardRepo(DashboardApi.create())
    }
}