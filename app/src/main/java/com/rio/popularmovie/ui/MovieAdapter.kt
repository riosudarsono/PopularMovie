package com.rio.popularmovie.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rio.popularmovie.Constanta
import com.rio.popularmovie.R
import com.rio.popularmovie.model.MovieData
import kotlinx.android.synthetic.main.view_movie.view.*
import java.util.zip.Inflater

class MovieAdapter(private var data: MutableList<MovieData>): RecyclerView.Adapter<MovieAdapter.Holder>() {

    fun addData(data: MutableList<MovieData>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_movie, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Holder(holder.itemView).bind(data[position])
    }

    inner class Holder(itemview:View):RecyclerView.ViewHolder(itemview){
        fun bind(data: MovieData){

            Glide.with(itemView.context)
                .load(Constanta.URL_IMAGE + data.poster_path)
                .into(itemView.iv_image)

            itemView.tv_title.text = data.title
            itemView.tv_desc.text = data.overview
            itemView.tv_date.text = data.release_date
        }
    }
}