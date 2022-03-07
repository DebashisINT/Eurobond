package com.eurobond.features.login.model.productlistmodel

import com.eurobond.app.domain.ModelEntity
import com.eurobond.app.domain.ProductListEntity
import com.eurobond.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}