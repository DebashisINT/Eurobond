package com.breezeeurobondfsm.features.newcollectionreport

import com.breezeeurobondfsm.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}