package com.breezeeurobondfsm.features.orderList.model

import com.breezeeurobondfsm.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}