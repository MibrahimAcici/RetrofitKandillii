package com.ibrahim.retrofitkandilli.service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class PlaceAPI {

    private val BASE_URL = "https://api.orhanaydogdu.com.tr/deprem/"

    private val placeApi: PlaceService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PlaceService::class.java)

    fun getPlaceService() = placeApi
}