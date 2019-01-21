package com.ozan.movieapp.data.response.tv.popular

import com.google.gson.annotations.SerializedName

data class PopularTvsResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<PopularTvsResultsItem?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)