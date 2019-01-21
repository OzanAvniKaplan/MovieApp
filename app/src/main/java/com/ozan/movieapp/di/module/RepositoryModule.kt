package com.ozan.movieapp.di.module

import com.ozan.movieapp.data.datasource.detail.DetailDataSource
import com.ozan.movieapp.data.datasource.movie.MovieDataSource
import com.ozan.movieapp.data.datasource.tv.TvDataSource
import com.ozan.movieapp.data.repository.detail.DetailRepository
import com.ozan.movieapp.data.repository.detail.DetailRepositoryImp
import com.ozan.movieapp.data.repository.movie.MovieRepository
import com.ozan.movieapp.data.repository.movie.MovieRepositoryImp
import com.ozan.movieapp.data.repository.tv.TvRepository
import com.ozan.movieapp.data.repository.tv.TvRepositoryImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceModule::class])
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideMovieRepository(movieDataSource: MovieDataSource): MovieRepository {
        return MovieRepositoryImp(movieDataSource)
    }

    @Provides
    @Singleton
    internal fun provideTvRepository(tvDataSource: TvDataSource): TvRepository{
        return TvRepositoryImp(tvDataSource)
    }

    @Provides
    @Singleton
    internal fun provideDetailRepository(detailDataSource: DetailDataSource): DetailRepository{
        return DetailRepositoryImp(detailDataSource)
    }

}