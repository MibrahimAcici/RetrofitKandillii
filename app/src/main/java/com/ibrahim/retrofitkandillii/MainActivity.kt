package com.ibrahim.retrofitkandillii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.retrofitkandillii.adapter.PlaceAdapter
import com.ibrahim.retrofitkandillii.databinding.ActivityMainBinding
import com.ibrahim.retrofitkandillii.model.PlaceResponse
import com.ibrahim.retrofitkandillii.viewmodel.PlaceViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val placeAdapter = PlaceAdapter()
    private lateinit var binding: ActivityMainBinding
    private var placeList: ArrayList<PlaceResponse.Result> = arrayListOf()
    private lateinit var placeViewModel: PlaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        placeViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)

        placeViewModel.placeList()
        observableLiveData()

        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = placeAdapter
    }
    private fun observableLiveData(){
        placeViewModel.placeListLiveData.observe(this) {
            it.result.forEach {res ->
                placeList.add(res)
            }
            placeAdapter.setPlaceNameList(placeList)
            progress.isVisible=false

        }

    }
}