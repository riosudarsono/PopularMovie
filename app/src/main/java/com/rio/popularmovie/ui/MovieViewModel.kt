package com.rio.popularmovie.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rio.popularmovie.model.BaseResponse
import com.rio.popularmovie.model.MovieData

class MovieViewModel(): ViewModel() {
    var repository = MainRepository()

    fun moviePopular(page: Int): LiveData<BaseResponse<MutableList<MovieData>>>{
        return repository.moviePopular(page)
    }
}