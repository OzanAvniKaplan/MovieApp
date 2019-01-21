package com.ozan.movieapp.data.repository.detail

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.datasource.detail.DetailDataSource
import com.ozan.movieapp.data.response.details.credits.CreditsResponse
import com.ozan.movieapp.data.response.details.moviedetail.MovieDetailResponse
import com.ozan.movieapp.data.response.details.tvdetail.TvDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailRepositoryImp @Inject constructor(private val detailDataSource: DetailDataSource) : DetailRepository {

    override suspend fun getTvDetail(id: Int): LiveData<TvDetailResponse> {
        return withContext(Dispatchers.IO) {
            detailDataSource.fetchCurrentTvDetail(id)
        }!!
    }

    override suspend fun getMovieDetail(id: Int): LiveData<MovieDetailResponse> {
        return withContext(Dispatchers.IO) {
            detailDataSource.fetchCurrentMovieDetail(id)
        }!!
    }

    override suspend fun getTvCredits(id: Int): LiveData<CreditsResponse> {
        return withContext(Dispatchers.IO) {
            detailDataSource.fetchCurrentTvCredits(id)
        }!!
    }

    override suspend fun getMovieCredits(id: Int): LiveData<CreditsResponse> {
        return withContext(Dispatchers.IO) {
            detailDataSource.fetchCurrentMovieCredits(id)
        }!!
    }
}