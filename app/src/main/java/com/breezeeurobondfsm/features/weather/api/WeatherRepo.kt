package com.breezeeurobondfsm.features.weather.api

import com.breezeeurobondfsm.base.BaseResponse
import com.breezeeurobondfsm.features.task.api.TaskApi
import com.breezeeurobondfsm.features.task.model.AddTaskInputModel
import com.breezeeurobondfsm.features.weather.model.ForeCastAPIResponse
import com.breezeeurobondfsm.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}