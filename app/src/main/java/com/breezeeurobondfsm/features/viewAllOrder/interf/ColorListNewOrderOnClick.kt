package com.breezeeurobondfsm.features.viewAllOrder.interf

import com.breezeeurobondfsm.app.domain.NewOrderColorEntity
import com.breezeeurobondfsm.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}