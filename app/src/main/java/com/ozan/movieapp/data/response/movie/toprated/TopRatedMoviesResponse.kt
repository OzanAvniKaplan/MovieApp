package com.ozan.movieapp.data.response.movie.toprated

import com.google.gson.annotations.SerializedName

data class TopRatedMoviesResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<TopRatedMoviesResultsItem?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)