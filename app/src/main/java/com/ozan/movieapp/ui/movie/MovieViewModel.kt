package com.ozan.movieapp.ui.movie

import androidx.lifecycle.ViewModel
import com.ozan.movieapp.data.repository.movie.MovieRepository
import com.ozan.movieapp.utils.lazyDeferred
import javax.inject.Inject

class MovieViewModel @Inject constructor(movieRepository: MovieRepository) : ViewModel() {

    val topRatedMovies by lazyDeferred {
        movieRepository.getTopRatedMovies()
    }
    val popularMovies by lazyDeferred {
        movieRepository.getPopularMovies()
    }
    val nowPlaying by lazyDeferred {
        movieRepository.getNowPlaying()
    }

}
