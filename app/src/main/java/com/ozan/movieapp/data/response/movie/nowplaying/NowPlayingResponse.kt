package com.ozan.movieapp.data.response.movie.nowplaying

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(

    @field:SerializedName("dates")
    val dates: Dates? = null,

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<NowPlayingResultsItem?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)