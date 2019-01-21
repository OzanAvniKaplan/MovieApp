package com.ozan.movieapp.data.datasource.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ozan.movieapp.data.network.ApiService
import com.ozan.movieapp.data.response.tv.popular.PopularTvsResponse
import com.ozan.movieapp.data.response.tv.toprated.TopRatedTvsResponse
import java.lang.Exception
import javax.inject.Inject

class TvDataSourceImp @Inject constructor(private val apiService: ApiService) : TvDataSource {
    // these used for pass fetched data to LiveData s
    private val mFetchedTopRatedTvs = MutableLiveData<TopRatedTvsResponse>()
    private val mFetchedPopularTvs = MutableLiveData<PopularTvsResponse>()

    override val fetchedTopRatedTvs: LiveData<TopRatedTvsResponse>
        get() = mFetchedTopRatedTvs
    override val fetchedPopularTvs: LiveData<PopularTvsResponse>
        get() = mFetchedPopularTvs

    override suspend fun fetchCurrentTopRatedTvs(): LiveData<TopRatedTvsResponse>? {
        try {
            val fetchedTopRated = apiService.getTopRatedTvs().await()
            mFetchedTopRatedTvs.postValue(fetchedTopRated)
            return fetchedTopRatedTvs
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null
    }

    override suspend fun fetchCurrentPopularTvs(): LiveData<PopularTvsResponse>? {
        try {
            val fetchedPopular = apiService.getPopularTvs().await()
            mFetchedPopularTvs.postValue(fetchedPopular)
            return fetchedPopularTvs
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null
    }
}