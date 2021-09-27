package com.example.movieapp.model

data class Results(
    var id: Int? = 0,
    var original_language: String? = null,
    var original_title: String? = null,
    var overview: String? = null,
    var poster_path: String? = null,
    var release_date: String? = null,
    var popularity: Double? = 0.0
)