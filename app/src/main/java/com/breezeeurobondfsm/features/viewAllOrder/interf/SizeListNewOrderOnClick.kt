package com.breezeeurobondfsm.features.viewAllOrder.interf

import com.breezeeurobondfsm.app.domain.NewOrderProductEntity
import com.breezeeurobondfsm.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}