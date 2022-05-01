package com.ibrahim.retrofitkandilli.service
import com.ibrahim.retrofitkandillii.model.PlacesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
//https://api.orhanaydogdu.com.tr/deprem/live.php?limit=100
//BASE URL     /     "live.php" GET içerisine yazılacak
//BASE URL     /..... ?    "limit" Query içerisine yazılacak
//BASE URL     /live.php?limit=100 getPlaces fun çağırıldığında 100 değeri girilecek getPlaces(100) şeklinde
//Liste değil [ ile başlamıyor Call<List<şeklinde yazmadık
   /*
    @GET("index.php?date=2022-04-29")
    fun getPlaces(@Query("limit") limit: Int) : Call<PlacesResponse>
        */
    @GET("index.php")
    fun getPlaces(@Query("date") date: String,@Query("limit") limit:Int) : Call<PlacesResponse>

}