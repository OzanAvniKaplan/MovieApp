package com.ozan.movieapp.data.repository.tv

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.datasource.tv.TvDataSource
import com.ozan.movieapp.data.response.tv.popular.PopularTvsResponse
import com.ozan.movieapp.data.response.tv.toprated.TopRatedTvsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TvRepositoryImp @Inject constructor(private val tvDataSource: TvDataSource) : TvRepository {

    override suspend fun getTopRatedTvs(): LiveData<TopRatedTvsResponse> {
        return withContext(Dispatchers.IO) {
            tvDataSource.fetchCurrentTopRatedTvs()
        }!!
    }

    override suspend fun getPopularTvs(): LiveData<PopularTvsResponse> {
        return withContext(Dispatchers.IO) {
            tvDataSource.fetchCurrentPopularTvs()
        }!!
    }

}