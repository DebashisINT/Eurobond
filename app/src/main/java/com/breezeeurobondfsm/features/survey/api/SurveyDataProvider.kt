package com.breezeeurobondfsm.features.survey.api

import com.breezeeurobondfsm.features.photoReg.api.GetUserListPhotoRegApi
import com.breezeeurobondfsm.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}