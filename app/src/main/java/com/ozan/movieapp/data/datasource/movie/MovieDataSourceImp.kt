package com.ozan.movieapp.data.datasource.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ozan.movieapp.data.network.ApiService
import com.ozan.movieapp.data.response.movie.nowplaying.NowPlayingResponse
import com.ozan.movieapp.data.response.movie.popular.PopularMoviesResponse
import com.ozan.movieapp.data.response.movie.toprated.TopRatedMoviesResponse
import java.lang.Exception
import javax.inject.Inject

class MovieDataSourceImp @Inject constructor(private val apiService: ApiService) : MovieDataSource {

    // these used for pass fetched data to LiveData s
    private val mFetchedTopRatedMovies = MutableLiveData<TopRatedMoviesResponse>()
    private val mFetchedPopularMovies = MutableLiveData<PopularMoviesResponse>()
    private val mFetchedNowPlayingMovies = MutableLiveData<NowPlayingResponse>()

    // these will be LiveDatas returned
    override val fetchedPopularMovies: LiveData<PopularMoviesResponse>
        get() = mFetchedPopularMovies
    override val fetchedTopRatedMovies: LiveData<TopRatedMoviesResponse>
        get() = mFetchedTopRatedMovies
    override val fetchedNowPlayingMovies: LiveData<NowPlayingResponse>
        get() = mFetchedNowPlayingMovies

    // fetch data from api and set new value for TopRatedMoviesResponse model
    override suspend fun fetchCurrentTopRatedMovies(): LiveData<TopRatedMoviesResponse>? {
        try {
            val fetchedTopRated = apiService.getTopRatedMovies().await()
            mFetchedTopRatedMovies.postValue(fetchedTopRated)
            return fetchedTopRatedMovies
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null
    }

    // fetch data from api and set new value for PopularMoviesResponse model
    override suspend fun fetchCurrentPopularMovies(): LiveData<PopularMoviesResponse>? {
        try {
            val fetchedPopular = apiService.getPopularMovies().await()
            mFetchedPopularMovies.postValue(fetchedPopular)
            return fetchedPopularMovies
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null
    }

    // fetch data from api and set new value for NowPlayingResponse model
    override suspend fun fetchCurrentNowPlayingMovies(): LiveData<NowPlayingResponse>? {
        try {
            val fetchedNowPlaying = apiService.getNowPlayingMovies().await()
            mFetchedNowPlayingMovies.postValue(fetchedNowPlaying)
            return fetchedNowPlayingMovies
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message)
        }
        return null

    }

}