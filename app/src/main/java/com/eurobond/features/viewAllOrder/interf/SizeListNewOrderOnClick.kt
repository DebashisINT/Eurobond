package com.eurobond.features.viewAllOrder.interf

import com.eurobond.app.domain.NewOrderProductEntity
import com.eurobond.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}