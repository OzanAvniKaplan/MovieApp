package com.ozan.movieapp.di.module

import androidx.lifecycle.ViewModelProvider
import com.ozan.movieapp.ui.movie.MovieViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindMovieViewModelFactory(movieViewModelFactory: MovieViewModelFactory): ViewModelProvider.Factory
}
