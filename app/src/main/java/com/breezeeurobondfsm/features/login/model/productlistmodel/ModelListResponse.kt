package com.breezeeurobondfsm.features.login.model.productlistmodel

import com.breezeeurobondfsm.app.domain.ModelEntity
import com.breezeeurobondfsm.app.domain.ProductListEntity
import com.breezeeurobondfsm.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}