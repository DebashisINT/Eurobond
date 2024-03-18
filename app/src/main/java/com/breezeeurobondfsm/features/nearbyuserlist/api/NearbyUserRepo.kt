package com.breezeeurobondfsm.features.nearbyuserlist.api

import com.breezeeurobondfsm.app.Pref
import com.breezeeurobondfsm.features.nearbyuserlist.model.NearbyUserResponseModel
import com.breezeeurobondfsm.features.newcollection.model.NewCollectionListResponseModel
import com.breezeeurobondfsm.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}