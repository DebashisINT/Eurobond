package com.eurobond.features.viewAllOrder.interf

import com.eurobond.app.domain.NewOrderGenderEntity
import com.eurobond.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}