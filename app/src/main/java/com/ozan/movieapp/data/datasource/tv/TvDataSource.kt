package com.ozan.movieapp.data.datasource.tv

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.response.tv.popular.PopularTvsResponse
import com.ozan.movieapp.data.response.tv.toprated.TopRatedTvsResponse

interface TvDataSource {

    //Livedata variables
    val fetchedTopRatedTvs: LiveData<TopRatedTvsResponse>
    val fetchedPopularTvs: LiveData<PopularTvsResponse>

    //For getting data from api
    suspend fun fetchCurrentTopRatedTvs(): LiveData<TopRatedTvsResponse>?
    suspend fun fetchCurrentPopularTvs(): LiveData<PopularTvsResponse>?

}