package com.ozan.movieapp.di.module

import android.app.Application
import com.ozan.movieapp.MovieApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    var mApplication =  MovieApp()

    fun AppModule(application: MovieApp){
        mApplication = application
    }

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return mApplication
    }

}