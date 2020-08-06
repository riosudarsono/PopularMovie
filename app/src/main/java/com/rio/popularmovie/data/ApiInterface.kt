package com.rio.popularmovie.data

import com.rio.popularmovie.model.BaseResponse
import com.rio.popularmovie.model.MovieData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movie/popular")
    fun moviePopular(@Query("api_key") key: String,
                     @Query("language") language: String,
                     @Query("page") page: Int): Observable<BaseResponse<MutableList<MovieData>>>
}