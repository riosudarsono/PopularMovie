package com.rio.popularmovie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rio.popularmovie.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var movieAdapter: MovieAdapter

    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        setContent()
        getData()
    }

    fun setContent(){
        rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        movieAdapter = MovieAdapter(ArrayList())
        rv_movie.adapter = movieAdapter
    }

    fun getData(){
        viewModel.moviePopular(1).observe(this, Observer {
            movieAdapter.addData(it.results)
        })
    }
}