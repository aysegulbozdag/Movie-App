package com.example.movieapp.model

data class PopularList(
    var page: Int? = null,
    var results: ArrayList<Results>? = null
)