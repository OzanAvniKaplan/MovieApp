package com.ozan.movieapp.data.network

import com.ozan.movieapp.data.response.details.credits.CreditsResponse
import com.ozan.movieapp.data.response.details.moviedetail.MovieDetailResponse
import com.ozan.movieapp.data.response.details.tvdetail.TvDetailResponse
import com.ozan.movieapp.data.response.movie.nowplaying.NowPlayingResponse
import com.ozan.movieapp.data.response.movie.popular.PopularMoviesResponse
import com.ozan.movieapp.data.response.movie.toprated.TopRatedMoviesResponse
import com.ozan.movieapp.data.response.tv.popular.PopularTvsResponse
import com.ozan.movieapp.data.response.tv.toprated.TopRatedTvsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("movie/top_rated")
    fun getTopRatedMovies(): Deferred<TopRatedMoviesResponse>

    @GET("movie/now_playing")
    fun getNowPlayingMovies(): Deferred<NowPlayingResponse>

    @GET("movie/popular")
    fun getPopularMovies(): Deferred<PopularMoviesResponse>

    @GET("tv/top_rated")
    fun getTopRatedTvs(): Deferred<TopRatedTvsResponse>

    @GET("tv/popular")
    fun getPopularTvs(): Deferred<PopularTvsResponse>

    @GET("movie/{id}")
    fun getMovieDetail(@Path("id") id: Int): Deferred<MovieDetailResponse>

    @GET("tv/{id}")
    fun getTvDetail(@Path("id") id: Int): Deferred<TvDetailResponse>

    @GET("movie/{id}/credits")
    fun getMovieCredits(@Path("id") id: Int): Deferred<CreditsResponse>

    @GET("tv/{id}/credits")
    fun getTvCredits(@Path("id") id: Int): Deferred<CreditsResponse>

}