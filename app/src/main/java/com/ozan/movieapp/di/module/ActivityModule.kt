package com.ozan.movieapp.di.module

import com.ozan.movieapp.MainActivity
import com.ozan.movieapp.ui.detail.DetailActivity
import com.ozan.movieapp.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeDetailActivity(): DetailActivity

    @ContributesAndroidInjector()
    abstract fun contributeSplashActivity(): SplashActivity
}