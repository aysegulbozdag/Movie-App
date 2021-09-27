package com.example.movieapp.service

import com.example.movieapp.model.PopularList
import com.example.movieapp.model.Results
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.github.com/search/repositories?q=ny
interface RetroService {
    @GET("popular")
    suspend fun getDataFromApi(
        @Query("api_key") key: String,
        @Query("language") language: String, @Query("page") page: Int
    ) : PopularList

}