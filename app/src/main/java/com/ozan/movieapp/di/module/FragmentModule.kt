package com.ozan.movieapp.di.module

import com.ozan.movieapp.ui.movie.MovieFragment
import com.ozan.movieapp.ui.tv.TvFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    /*
     * We define the name of the Fragment we are going
    * to inject the ViewModelFactory into. i.e. in our case
    * The name of the fragment: MovieListFragment
    */
    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeTvFragment(): TvFragment
}