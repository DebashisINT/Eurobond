package com.breezeeurobondfsm.features.photoReg.present

import com.breezeeurobondfsm.app.domain.ProspectEntity
import com.breezeeurobondfsm.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}