package com.ozan.movieapp.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ozan.movieapp.data.repository.movie.MovieRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory @Inject constructor(private val repository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(repository) as T
    }

}