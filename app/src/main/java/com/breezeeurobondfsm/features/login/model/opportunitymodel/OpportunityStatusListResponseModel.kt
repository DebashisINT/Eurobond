package com.breezeeurobondfsm.features.login.model.opportunitymodel

import com.breezeeurobondfsm.app.domain.OpportunityStatusEntity
import com.breezeeurobondfsm.app.domain.ProductListEntity
import com.breezeeurobondfsm.base.BaseResponse

/**
 * Created by Puja on 30.05.2024
 */
class OpportunityStatusListResponseModel : BaseResponse() {
    var status_list: ArrayList<OpportunityStatusEntity>? = null
}