package com.rio.popularmovie.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieData(
    var id: String,
    var title: String,
    var overview: String,
    var release_date: String,
    var poster_path: String): Parcelable {
}