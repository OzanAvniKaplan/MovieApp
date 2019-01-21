package com.ozan.movieapp.data.datasource.movie

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.response.movie.nowplaying.NowPlayingResponse
import com.ozan.movieapp.data.response.movie.popular.PopularMoviesResponse
import com.ozan.movieapp.data.response.movie.toprated.TopRatedMoviesResponse

interface MovieDataSource {

    //Livedata variables
    val fetchedTopRatedMovies: LiveData<TopRatedMoviesResponse>
    val fetchedPopularMovies: LiveData<PopularMoviesResponse>
    val fetchedNowPlayingMovies: LiveData<NowPlayingResponse>

    //For getting data from api
    suspend fun fetchCurrentTopRatedMovies(): LiveData<TopRatedMoviesResponse>?
    suspend fun fetchCurrentPopularMovies(): LiveData<PopularMoviesResponse>?
    suspend fun fetchCurrentNowPlayingMovies(): LiveData<NowPlayingResponse>?

}
