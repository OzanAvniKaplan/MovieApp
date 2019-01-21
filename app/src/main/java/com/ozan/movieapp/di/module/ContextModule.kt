package com.ozan.movieapp.di.module

import android.content.Context
import com.ozan.movieapp.MovieApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return MovieApp()
    }

}