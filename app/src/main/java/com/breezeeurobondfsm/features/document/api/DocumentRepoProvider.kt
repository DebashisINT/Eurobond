package com.breezeeurobondfsm.features.document.api

import com.breezeeurobondfsm.features.dymanicSection.api.DynamicApi
import com.breezeeurobondfsm.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}