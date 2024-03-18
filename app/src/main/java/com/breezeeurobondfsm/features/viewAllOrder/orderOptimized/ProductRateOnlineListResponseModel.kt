package com.breezeeurobondfsm.features.viewAllOrder.orderOptimized

import com.breezeeurobondfsm.app.domain.ProductOnlineRateTempEntity
import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}