package com.example.movieapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetronIstance {

    companion object {
        val BaseUrl = "https://api.themoviedb.org/3/movie/"

        fun getRetronIstace(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}