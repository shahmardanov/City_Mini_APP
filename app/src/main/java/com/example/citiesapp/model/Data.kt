package com.example.citiesapp.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("cities")
    val cities: String,
    @SerializedName("slug")
    val slug: String
)