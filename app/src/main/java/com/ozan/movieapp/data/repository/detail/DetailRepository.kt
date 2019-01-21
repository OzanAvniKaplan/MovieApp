package com.ozan.movieapp.data.repository.detail

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.response.details.credits.CreditsResponse
import com.ozan.movieapp.data.response.details.moviedetail.MovieDetailResponse
import com.ozan.movieapp.data.response.details.tvdetail.TvDetailResponse

interface DetailRepository {
    suspend fun getTvDetail(id: Int): LiveData<TvDetailResponse>
    suspend fun getMovieDetail(id: Int): LiveData<MovieDetailResponse>
    suspend fun getTvCredits(id: Int): LiveData<CreditsResponse>
    suspend fun getMovieCredits(id: Int): LiveData<CreditsResponse>
}