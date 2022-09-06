package com.eurobond.features.weather.api

import com.eurobond.base.BaseResponse
import com.eurobond.features.task.api.TaskApi
import com.eurobond.features.task.model.AddTaskInputModel
import com.eurobond.features.weather.model.ForeCastAPIResponse
import com.eurobond.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}