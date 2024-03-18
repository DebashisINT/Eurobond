package com.breezeeurobondfsm.features.weather.api

import com.breezeeurobondfsm.features.task.api.TaskApi
import com.breezeeurobondfsm.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}