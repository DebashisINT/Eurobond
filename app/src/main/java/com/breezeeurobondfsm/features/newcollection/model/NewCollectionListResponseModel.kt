package com.breezeeurobondfsm.features.newcollection.model

import com.breezeeurobondfsm.app.domain.CollectionDetailsEntity
import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}