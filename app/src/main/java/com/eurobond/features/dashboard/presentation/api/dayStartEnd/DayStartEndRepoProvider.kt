package com.eurobond.features.dashboard.presentation.api.dayStartEnd

import com.eurobond.features.stockCompetetorStock.api.AddCompStockApi
import com.eurobond.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}