package com.ibrahim.retrofitkandilli.service
import com.ibrahim.retrofitkandillii.model.PlaceResponse
import com.ibrahim.retrofitkandillii.util.PlaceContants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceAPI {
    companion object {
        const val PLACES = "deprem/index.php"
    }
    @GET(PLACES)
    fun getPlaces(
        @Query("date") language: String = PlaceContants.DATE,
        @Query("limit") limit: String = PlaceContants.LIMIT
    ): Single<PlaceResponse>
}