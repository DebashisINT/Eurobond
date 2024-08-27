package com.breezeeurobondfsm.features.mylearning.apiCall

import com.breezeeurobondfsm.features.login.api.opportunity.OpportunityListApi
import com.breezeeurobondfsm.features.login.api.opportunity.OpportunityListRepo

object LMSRepoProvider {
    fun getTopicList(): LMSRepo {
        return LMSRepo(LMSApi.create())
    }
}