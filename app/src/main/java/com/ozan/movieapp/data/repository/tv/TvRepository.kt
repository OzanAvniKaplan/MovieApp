package com.ozan.movieapp.data.repository.tv

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.response.tv.popular.PopularTvsResponse
import com.ozan.movieapp.data.response.tv.toprated.TopRatedTvsResponse

interface TvRepository {
    suspend fun getTopRatedTvs(): LiveData<TopRatedTvsResponse>
    suspend fun getPopularTvs(): LiveData<PopularTvsResponse>
}