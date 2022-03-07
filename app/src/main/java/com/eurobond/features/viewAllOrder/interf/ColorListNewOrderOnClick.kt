package com.eurobond.features.viewAllOrder.interf

import com.eurobond.app.domain.NewOrderColorEntity
import com.eurobond.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}