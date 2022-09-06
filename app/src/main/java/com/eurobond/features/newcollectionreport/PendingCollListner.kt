package com.eurobond.features.newcollectionreport

import com.eurobond.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}