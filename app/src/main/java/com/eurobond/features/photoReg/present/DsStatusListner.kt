package com.eurobond.features.photoReg.present

import com.eurobond.app.domain.ProspectEntity
import com.eurobond.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}