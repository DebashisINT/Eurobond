package com.breezeeurobondfsm.features.dashboard.presentation.api.dayStartEnd

import com.breezeeurobondfsm.features.stockCompetetorStock.api.AddCompStockApi
import com.breezeeurobondfsm.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}