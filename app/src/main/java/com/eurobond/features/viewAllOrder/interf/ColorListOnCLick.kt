package com.eurobond.features.viewAllOrder.interf

import com.eurobond.app.domain.NewOrderGenderEntity
import com.eurobond.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}