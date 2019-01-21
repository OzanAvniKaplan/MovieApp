package com.ozan.movieapp.data.datasource.detail

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.response.details.credits.CreditsResponse
import com.ozan.movieapp.data.response.details.moviedetail.MovieDetailResponse
import com.ozan.movieapp.data.response.details.tvdetail.TvDetailResponse

interface DetailDataSource {

    //Livedata variables
    val fetchedTvDetail: LiveData<TvDetailResponse>
    val fetchedMovieDetail: LiveData<MovieDetailResponse>
    val fetchedTvCredits: LiveData<CreditsResponse>
    val fetchedMovieCredits: LiveData<CreditsResponse>

    //For getting data from api
    suspend fun fetchCurrentTvDetail(id : Int) : LiveData<TvDetailResponse>?
    suspend fun fetchCurrentMovieDetail(id : Int) : LiveData<MovieDetailResponse>?
    suspend fun fetchCurrentTvCredits(id : Int) : LiveData<CreditsResponse>?
    suspend fun fetchCurrentMovieCredits(id : Int) : LiveData<CreditsResponse>?

}