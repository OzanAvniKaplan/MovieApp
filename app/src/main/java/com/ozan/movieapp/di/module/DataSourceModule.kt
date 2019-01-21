package com.ozan.movieapp.di.module

import com.ozan.movieapp.data.datasource.detail.DetailDataSource
import com.ozan.movieapp.data.datasource.detail.DetailDataSourceImp
import com.ozan.movieapp.data.datasource.movie.MovieDataSource
import com.ozan.movieapp.data.datasource.movie.MovieDataSourceImp
import com.ozan.movieapp.data.datasource.tv.TvDataSource
import com.ozan.movieapp.data.datasource.tv.TvDataSourceImp
import com.ozan.movieapp.data.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    internal fun provideMovieDatasource(apiService: ApiService): MovieDataSource {
        return MovieDataSourceImp(apiService)
    }
    @Provides
    @Singleton
    internal fun provideTvDatasource(apiService: ApiService): TvDataSource {
        return TvDataSourceImp(apiService)
    }
    @Provides
    @Singleton
    internal fun provideDetailDatasource(apiService: ApiService): DetailDataSource{
        return DetailDataSourceImp(apiService)
    }

}