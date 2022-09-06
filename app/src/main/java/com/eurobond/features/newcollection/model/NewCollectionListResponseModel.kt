package com.eurobond.features.newcollection.model

import com.eurobond.app.domain.CollectionDetailsEntity
import com.eurobond.base.BaseResponse
import com.eurobond.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}