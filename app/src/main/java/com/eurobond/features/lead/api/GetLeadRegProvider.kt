package com.eurobond.features.lead.api

import com.eurobond.features.NewQuotation.api.GetQuotListRegRepository
import com.eurobond.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}