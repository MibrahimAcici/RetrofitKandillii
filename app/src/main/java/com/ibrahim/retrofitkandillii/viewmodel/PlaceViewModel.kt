package com.ibrahim.retrofitkandillii.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibrahim.retrofitkandilli.service.PlaceService
import com.ibrahim.retrofitkandillii.model.PlaceResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PlaceViewModel(application: Application) : BaseViewModel(application) {

    private val PlaceSer = PlaceService()
    private val disposable = CompositeDisposable()

    private val _placeListLiveData = MutableLiveData<PlaceResponse>()
    val placeListLiveData : LiveData<PlaceResponse> = _placeListLiveData

    fun placeList(){
        disposable.add(
            PlaceSer.getPlaces()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PlaceResponse>() {
                    override fun onSuccess(response: PlaceResponse) {
                        _placeListLiveData.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}