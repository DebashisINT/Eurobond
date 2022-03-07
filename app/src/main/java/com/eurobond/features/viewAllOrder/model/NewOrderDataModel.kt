package com.eurobond.features.viewAllOrder.model

import com.eurobond.app.domain.NewOrderColorEntity
import com.eurobond.app.domain.NewOrderGenderEntity
import com.eurobond.app.domain.NewOrderProductEntity
import com.eurobond.app.domain.NewOrderSizeEntity
import com.eurobond.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

