package com.breezeeurobondfsm.features.photoReg.adapter

import com.breezeeurobondfsm.features.photoReg.model.ProsCustom
import com.breezeeurobondfsm.features.photoReg.model.UserListResponseModel

interface ProsListSelectionListner {
    fun getInfo(obj: ProsCustom)
}