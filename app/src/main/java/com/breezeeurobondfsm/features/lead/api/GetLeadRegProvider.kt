package com.breezeeurobondfsm.features.lead.api

import com.breezeeurobondfsm.features.NewQuotation.api.GetQuotListRegRepository
import com.breezeeurobondfsm.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}