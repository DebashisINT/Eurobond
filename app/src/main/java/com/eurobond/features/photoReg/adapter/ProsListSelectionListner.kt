package com.eurobond.features.photoReg.adapter

import com.eurobond.features.photoReg.model.ProsCustom
import com.eurobond.features.photoReg.model.UserListResponseModel

interface ProsListSelectionListner {
    fun getInfo(obj: ProsCustom)
}