package com.example.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.adapter.MovieListAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.model.PopularList
import com.example.movieapp.model.Results
import com.example.movieapp.viewmodel.MainWM

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var adapter: MovieListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setupList()
        itemUpdate()
    }

    private fun setupList() {
        val rvList = activityMainBinding.rv;
        rvList.layoutManager = LinearLayoutManager(this);
        adapter = MovieListAdapter(this)
        rvList.adapter = adapter
    }

    private fun itemUpdate() {
        val viewModel = ViewModelProvider(this).get(MainWM::class.java)
        viewModel.rvObserver().observe(this, Observer<PopularList> {
            if (it != null) {
                it.results?.let { it1 -> adapter.setUpdatedData(it1) }
            } else {
                Toast.makeText(this, "Hata alındı", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.callApi()
    }
}