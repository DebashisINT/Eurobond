package com.breezeeurobondfsm.features.viewAllOrder.interf

import com.breezeeurobondfsm.app.domain.NewOrderGenderEntity
import com.breezeeurobondfsm.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}