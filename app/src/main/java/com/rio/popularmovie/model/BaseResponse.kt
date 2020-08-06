package com.rio.popularmovie.model

class BaseResponse<T>(
    var page: Int,
    var total_results: Int,
    var total_pages: Int,
    var results: T) {

}