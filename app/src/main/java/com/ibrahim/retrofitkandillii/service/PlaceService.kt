package com.ibrahim.retrofitkandilli.service
import com.ibrahim.retrofitkandillii.model.PlacesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
//https://api.orhanaydogdu.com.tr/deprem/index.php?date=2020-01-01&limit=100

    @GET("index.php")
    fun getPlaces(@Query("date") date: String,@Query("limit") limit:Int) : Call<PlacesResponse>

}