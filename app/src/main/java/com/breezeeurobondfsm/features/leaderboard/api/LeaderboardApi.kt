package com.breezeeurobondfsm.features.leaderboard.api

import com.breezeeurobondfsm.app.NetworkConstant
import com.breezeeurobondfsm.base.BaseResponse
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
import com.breezeeurobondfsm.features.login.model.WhatsappApiData
import com.breezeeurobondfsm.features.login.model.WhatsappApiFetchData
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by Puja on 12-40-2014.
 */
interface LeaderboardApi {

    @FormUrlEncoded
    @POST("LeaderboardInfo/LeaderboardBranchLists")
    fun branchList(@Field("session_token") session_token: String): Observable<LeaderboardBranchData>

    @FormUrlEncoded
    @POST("LeaderboardInfo/LeaderboardOwnList")
    fun ownDatalist(@Field("user_id") user_id: String,@Field("activitybased") activitybased: String,@Field("branchwise") branchwise: String,@Field("flag") flag: String): Observable<LeaderboardOwnData>

    @FormUrlEncoded
    @POST("LeaderboardInfo/LeaderboardOverallList")
    fun overAllDatalist(@Field("user_id") user_id: String,@Field("activitybased") activitybased: String,@Field("branchwise") branchwise: String,@Field("flag") flag: String): Observable<LeaderboardOverAllData>


    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): LeaderboardApi {
            val retrofit = Retrofit.Builder()
                    .client(NetworkConstant.setTimeOut())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(NetworkConstant.ADD_SHOP_BASE_URL)
                    .build()

            return retrofit.create(LeaderboardApi::class.java)
        }

        fun createWithoutMultipart(): LeaderboardApi {
            val retrofit = Retrofit.Builder()
                    .client(NetworkConstant.setTimeOut())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(NetworkConstant.BASE_URL)
                    .build()

            return retrofit.create(LeaderboardApi::class.java)
        }
    }
}