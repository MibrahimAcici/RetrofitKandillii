package com.ibrahim.retrofitkandilli.service
import com.ibrahim.retrofitkandillii.model.PlaceResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class PlaceService {
    private val BASE_URL = "https://api.orhanaydogdu.com.tr/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PlaceAPI::class.java)

    fun getPlaces(): Single<PlaceResponse> {
        return api.getPlaces()
    }
}