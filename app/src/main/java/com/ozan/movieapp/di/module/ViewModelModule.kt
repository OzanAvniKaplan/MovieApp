package com.ozan.movieapp.di.module

import androidx.lifecycle.ViewModel
import com.ozan.movieapp.di.ViewModelKey
import com.ozan.movieapp.ui.movie.MovieViewModel
import com.ozan.movieapp.ui.tv.TvViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  MovieListViewModel.class as key,
     * and a Provider that will build a MovieListViewModel
     * object.
     *
     * */
    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    protected abstract fun bindMovieViewModel(movieViewModel: MovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvViewModel::class)
    protected abstract fun bindTvViewModel(tvViewModel: TvViewModel): ViewModel
}
