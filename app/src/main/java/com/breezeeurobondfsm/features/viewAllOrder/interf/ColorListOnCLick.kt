package com.breezeeurobondfsm.features.viewAllOrder.interf

import com.breezeeurobondfsm.app.domain.NewOrderGenderEntity
import com.breezeeurobondfsm.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}