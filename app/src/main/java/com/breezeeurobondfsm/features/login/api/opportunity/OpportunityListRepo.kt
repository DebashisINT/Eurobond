package com.breezeeurobondfsm.features.login.api.opportunity

import com.breezeeurobondfsm.app.Pref
import com.breezeeurobondfsm.app.utils.AppUtils
import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.addshop.model.AudioFetchDataCLass
import com.breezeeurobondfsm.features.dashboard.presentation.DashboardActivity
import com.breezeeurobondfsm.features.login.model.opportunitymodel.OpportunityStatusListResponseModel
import com.breezeeurobondfsm.features.login.model.productlistmodel.ProductListResponseModel
import com.breezeeurobondfsm.features.orderITC.SyncDeleteOppt
import com.breezeeurobondfsm.features.orderITC.SyncEditOppt
import com.breezeeurobondfsm.features.orderITC.SyncOppt
import com.breezeeurobondfsm.features.orderList.model.OpportunityListResponseModel
import io.reactivex.Observable
import timber.log.Timber

/**
 * Created by Saikat on 20-11-2018.
 */
class OpportunityListRepo(val apiService: OpportunityListApi) {
    fun getOpportunityStatus(session_token: String): Observable<OpportunityStatusListResponseModel> {
        return apiService.getOpportunityStatusList(session_token)
    }

    fun saveOpportunity(syncOppt: SyncOppt): Observable<BaseResponse> {
        return apiService.saveOpportunity(syncOppt)
    }

    fun editOpportunity(syncEditOppt: SyncEditOppt): Observable<BaseResponse> {
        return apiService.editOpportunity(syncEditOppt)
    }
    fun deleteOpportunity(syncDeleteOppt: SyncDeleteOppt): Observable<BaseResponse> {
        return apiService.deleteOpportunity(syncDeleteOppt)
    }
    fun getOpportunityL(user_id: String): Observable<OpportunityListResponseModel> {
        return apiService.getOpportunityL(user_id)
    }

    fun getAudioL(user_id: String,data_limit_in_days:String): Observable<AudioFetchDataCLass> {
        return apiService.getAudioLApi(user_id,data_limit_in_days)
    }


    fun saveLMSModuleInfo(obj: DashboardActivity.LMSModule): Observable<BaseResponse> {
        return apiService.saveLMSModuleInfoApi(obj)
    }
}