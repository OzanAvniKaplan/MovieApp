package com.ozan.movieapp

import android.app.Activity
import android.app.Application
import com.ozan.movieapp.di.component.DaggerAppComponent
import com.ozan.movieapp.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MovieApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule())
            .build()
            .inject(this)
    }
}