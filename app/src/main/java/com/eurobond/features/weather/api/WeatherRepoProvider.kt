package com.eurobond.features.weather.api

import com.eurobond.features.task.api.TaskApi
import com.eurobond.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}