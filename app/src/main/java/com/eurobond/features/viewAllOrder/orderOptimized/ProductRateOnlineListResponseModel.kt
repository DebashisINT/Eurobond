package com.eurobond.features.viewAllOrder.orderOptimized

import com.eurobond.app.domain.ProductOnlineRateTempEntity
import com.eurobond.base.BaseResponse
import com.eurobond.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}