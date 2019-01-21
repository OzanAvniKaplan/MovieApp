package com.ozan.movieapp.data.repository.movie

import androidx.lifecycle.LiveData
import com.ozan.movieapp.data.response.movie.nowplaying.NowPlayingResponse
import com.ozan.movieapp.data.response.movie.popular.PopularMoviesResponse
import com.ozan.movieapp.data.response.movie.toprated.TopRatedMoviesResponse

interface MovieRepository {
    suspend fun getTopRatedMovies(): LiveData<TopRatedMoviesResponse>
    suspend fun getPopularMovies(): LiveData<PopularMoviesResponse>
    suspend fun getNowPlaying(): LiveData<NowPlayingResponse>
}