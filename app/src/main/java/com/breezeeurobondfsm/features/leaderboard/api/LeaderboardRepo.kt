package com.breezeeurobondfsm.features.leaderboard.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.breezeeurobondfsm.app.FileUtils
import com.breezeeurobondfsm.app.Pref
import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.addshop.model.AddLogReqData
import com.breezeeurobondfsm.features.addshop.model.AddShopRequestData
import com.breezeeurobondfsm.features.addshop.model.AddShopResponse
import com.breezeeurobondfsm.features.addshop.model.LogFileResponse
import com.breezeeurobondfsm.features.addshop.model.UpdateAddrReq
import com.breezeeurobondfsm.features.contacts.CallHisDtls
import com.breezeeurobondfsm.features.contacts.CompanyReqData
import com.breezeeurobondfsm.features.contacts.ContactMasterRes
import com.breezeeurobondfsm.features.contacts.SourceMasterRes
import com.breezeeurobondfsm.features.contacts.StageMasterRes
import com.breezeeurobondfsm.features.contacts.StatusMasterRes
import com.breezeeurobondfsm.features.contacts.TypeMasterRes
import com.breezeeurobondfsm.features.dashboard.presentation.DashboardActivity
import com.breezeeurobondfsm.features.login.model.WhatsappApiData
import com.breezeeurobondfsm.features.login.model.WhatsappApiFetchData
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * Created by Puja on 10-10-2024.
 */
class LeaderboardRepo(val apiService: LeaderboardApi) {

    fun branchlist(session_token: String): Observable<LeaderboardBranchData> {
        return apiService.branchList(session_token)
    }
    fun ownDatalist(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOwnData> {
        return apiService.ownDatalist(user_id,activitybased,branchwise,flag)
    }
    fun overAllAPI(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOverAllData> {
        return apiService.overAllDatalist(user_id,activitybased,branchwise,flag)
    }
}