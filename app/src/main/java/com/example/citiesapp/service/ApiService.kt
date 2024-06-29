package com.example.citiesapp.service

import com.example.citiesapp.model.CityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("cities")
    suspend fun getAllCities(@Query("apiKey") apiKey: String="gvloSjuIbqB3u0EDg5OrFcIOG2ac74gAgi46NVEYweHnNfaEcF6yajYAxC8M")
    : Response<CityResponse>
}