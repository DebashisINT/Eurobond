package com.breezeeurobondfsm.features.mylearning.apiCall

import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.login.api.opportunity.OpportunityListApi
import com.breezeeurobondfsm.features.login.model.opportunitymodel.OpportunityStatusListResponseModel
import com.breezeeurobondfsm.features.mylearning.CONTENT_WISE_QA_SAVE
import com.breezeeurobondfsm.features.mylearning.ContentCountSave_Data
import com.breezeeurobondfsm.features.mylearning.LMS_CONTENT_INFO
import com.breezeeurobondfsm.features.mylearning.MyCommentListResponse
import com.breezeeurobondfsm.features.mylearning.MyLarningListResponse
import com.breezeeurobondfsm.features.mylearning.TopicListResponse
import com.breezeeurobondfsm.features.mylearning.VideoPlayLMS
import com.breezeeurobondfsm.features.mylearning.VideoTopicWiseResponse
import io.reactivex.Observable

class LMSRepo(val apiService: LMSApi) {

    fun getTopics(user_id: String): Observable<TopicListResponse> {
        return apiService.getTopics(user_id)
    }

    fun getTopicsWiseVideo(user_id: String ,topic_id: String): Observable<VideoTopicWiseResponse> {
        return apiService.getTopicswiseVideoApi(user_id,topic_id)
    }

    fun saveContentInfoApi(lms_content_info: LMS_CONTENT_INFO): Observable<BaseResponse> {
        return apiService.saveContentInfoApi(lms_content_info)
    }

    fun getMyLraningInfo(user_id: String): Observable<MyLarningListResponse> {
        return apiService.getMyLearningContentList(user_id)
    }

    fun getCommentInfo(topic_id: String ,content_id: String): Observable<MyCommentListResponse> {
        return apiService.getCommentInfo(topic_id , content_id)
    }

    fun saveContentWiseQAApi(mCONTENT_WISE_QA_SAVE: CONTENT_WISE_QA_SAVE): Observable<BaseResponse> {
        return apiService.saveContentWiseQAApi(mCONTENT_WISE_QA_SAVE)
    }

    fun saveContentCount(mContentCountSave_Data: ContentCountSave_Data): Observable<BaseResponse> {
        return apiService.saveContentCount(mContentCountSave_Data)
    }
}