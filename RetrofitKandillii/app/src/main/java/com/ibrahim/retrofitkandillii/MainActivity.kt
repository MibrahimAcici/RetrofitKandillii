package com.ibrahim.retrofitkandillii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.retrofitkandilli.service.PlaceAPI
import com.ibrahim.retrofitkandillii.adapter.PlaceAdapter
import com.ibrahim.retrofitkandillii.databinding.ActivityMainBinding
import com.ibrahim.retrofitkandillii.model.PlacesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding //Viewbinding
    lateinit var placeAdapter: PlaceAdapter  //Adapter tanımlama
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater) //Viewbinding
        setContentView(binding.root) //Viewbinding

        initAdapter()
        fetchPlace()
    }

    private fun initAdapter() {
        //Adapter Tanımlayıp başlatma
        placeAdapter = PlaceAdapter()
        binding.recyclerView.adapter = placeAdapter
        //Adapterin Ekrandaki Görünümü
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
    }

    private fun fetchPlace() {
        binding.recyclerView.isVisible = false
        binding.progress.isVisible = true
        //Servise istek atma
        //val request=PlaceAPI().getPlaceService().getPlaces(100)
        val request=PlaceAPI().getPlaceService().getPlaces("2022-04-29",5)
        request.enqueue(object : Callback<PlacesResponse> {//Liste değil [ ile başlamıyor Callback<List<şeklinde yazmadık
        override fun onResponse(
            call: Call<PlacesResponse>,
            response: Response<PlacesResponse>
        ) {
            //Toast.makeText(applicationContext, response.body()?.result?.get(0)?.lokasyon,Toast.LENGTH_LONG).show()

            placeAdapter.setList(response.body()?.result ?: emptyList())
            binding.recyclerView.isVisible = true
            binding.progress.isVisible = false
        }

            override fun onFailure(call: Call<PlacesResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.message.toString(), Toast.LENGTH_LONG).show()
                binding.recyclerView.isVisible = true
                binding.progress.isVisible = false
            }
        })
    }}
