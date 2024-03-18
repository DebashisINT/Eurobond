package com.breezeeurobondfsm.features.viewAllOrder.model

import com.breezeeurobondfsm.app.domain.NewOrderColorEntity
import com.breezeeurobondfsm.app.domain.NewOrderGenderEntity
import com.breezeeurobondfsm.app.domain.NewOrderProductEntity
import com.breezeeurobondfsm.app.domain.NewOrderSizeEntity
import com.breezeeurobondfsm.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

