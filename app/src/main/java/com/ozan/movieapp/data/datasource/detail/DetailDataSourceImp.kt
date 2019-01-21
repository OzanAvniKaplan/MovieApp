package com.ozan.movieapp.data.datasource.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ozan.movieapp.data.network.ApiService
import com.ozan.movieapp.data.response.details.credits.CreditsResponse
import com.ozan.movieapp.data.response.details.moviedetail.MovieDetailResponse
import com.ozan.movieapp.data.response.details.tvdetail.TvDetailResponse
import java.lang.Exception
import javax.inject.Inject

class DetailDataSourceImp @Inject constructor(private val apiService: ApiService): DetailDataSource {

    // these used for pass fetched data to LiveData s
    private val mFetchedTvDetail = MutableLiveData<TvDetailResponse>()
    private val mFetchedMovieDetail = MutableLiveData<MovieDetailResponse>()
    private val mFetchedTvCredits = MutableLiveData<CreditsResponse>()
    private val mFetchedMovieCredits = MutableLiveData<CreditsResponse>()

    override val fetchedTvDetail: LiveData<TvDetailResponse>
        get() = mFetchedTvDetail
    override val fetchedMovieDetail: LiveData<MovieDetailResponse>
        get() = mFetchedMovieDetail
    override val fetchedTvCredits: LiveData<CreditsResponse>
        get() = mFetchedTvCredits
    override val fetchedMovieCredits: LiveData<CreditsResponse>
        get() = mFetchedMovieCredits

    override suspend fun fetchCurrentTvDetail(id : Int): LiveData<TvDetailResponse>? {
        try {
            val tvDetail = apiService.getTvDetail(id).await()
            mFetchedTvDetail.postValue(tvDetail)
            return fetchedTvDetail
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null
    }

    override suspend fun fetchCurrentMovieDetail(id : Int): LiveData<MovieDetailResponse>? {
        try {
            val moviesDetail = apiService.getMovieDetail(id).await()
            mFetchedMovieDetail.postValue(moviesDetail )
            return fetchedMovieDetail
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null
    }

    override suspend fun fetchCurrentTvCredits(id : Int): LiveData<CreditsResponse>? {
        try {
            val tvCredits = apiService.getTvCredits(id).await()
            mFetchedTvCredits.postValue(tvCredits)
            return fetchedTvCredits
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null
    }

    override suspend fun fetchCurrentMovieCredits(id : Int): LiveData<CreditsResponse>? {
        try {
            val movieCredits = apiService.getMovieCredits(id).await()
            mFetchedMovieCredits.postValue(movieCredits)
            return fetchedMovieCredits
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null
    }

}