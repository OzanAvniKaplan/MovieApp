package com.ozan.movieapp.data.repository.movie

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.datasource.movie.MovieDataSource
import com.ozan.movieapp.data.response.movie.nowplaying.NowPlayingResponse
import com.ozan.movieapp.data.response.movie.popular.PopularMoviesResponse
import com.ozan.movieapp.data.response.movie.toprated.TopRatedMoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImp @Inject constructor(private val movieDataSource: MovieDataSource) : MovieRepository {

    override suspend fun getNowPlaying(): LiveData<NowPlayingResponse> {
        return withContext(Dispatchers.IO) {
            movieDataSource.fetchCurrentNowPlayingMovies()
        }!!
    }

    override suspend fun getPopularMovies(): LiveData<PopularMoviesResponse> {
        return withContext(Dispatchers.IO) {
            movieDataSource.fetchCurrentPopularMovies()
        }!!
    }

    override suspend fun getTopRatedMovies(): LiveData<TopRatedMoviesResponse> {
        return withContext(Dispatchers.IO) {
            movieDataSource.fetchCurrentTopRatedMovies()
        }!!
    }
}
