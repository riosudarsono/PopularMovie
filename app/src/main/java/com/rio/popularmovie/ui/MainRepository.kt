package com.rio.popularmovie.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.rio.popularmovie.Constanta
import com.rio.popularmovie.data.ApiService
import com.rio.popularmovie.model.BaseResponse
import com.rio.popularmovie.model.MovieData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository() {
    private val apiService = ApiService().retrofit
    private val compositeDisposable = CompositeDisposable()

    fun moviePopular(page:Int): MutableLiveData<BaseResponse<MutableList<MovieData>>>{
        var data:MutableLiveData<BaseResponse<MutableList<MovieData>>> = MutableLiveData()

        compositeDisposable.add(apiService.moviePopular(Constanta.KEY, Constanta.LANGUAGE, page).observeOn(
            AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({response ->
                data.value = response
            },{error ->
                Log.d("Tag", error.message)
            })
        )
        return data
    }
}