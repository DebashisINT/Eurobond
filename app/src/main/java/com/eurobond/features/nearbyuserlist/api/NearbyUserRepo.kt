package com.eurobond.features.nearbyuserlist.api

import com.eurobond.app.Pref
import com.eurobond.features.nearbyuserlist.model.NearbyUserResponseModel
import com.eurobond.features.newcollection.model.NewCollectionListResponseModel
import com.eurobond.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}