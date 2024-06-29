package com.example.citiesapp.repo

import com.example.citiesapp.model.CityResponse
import com.example.citiesapp.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CityRepository @Inject constructor(private val service: ApiService) {

    suspend fun getAllCities(): Response<CityResponse> = withContext(Dispatchers.IO) {
        return@withContext service.getAllCities()
    }
}