package com.ozan.movieapp.data.response.tv.toprated

import com.google.gson.annotations.SerializedName

data class TopRatedTvsResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<TopRatedTvsResultsItem?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)