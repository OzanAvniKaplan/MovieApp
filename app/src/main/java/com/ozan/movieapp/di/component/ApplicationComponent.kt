package com.ozan.movieapp.di.component

import com.ozan.movieapp.MovieApp
import com.ozan.movieapp.di.module.ViewModelModule
import com.ozan.movieapp.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityModule::class,
        FragmentModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class]
)

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MovieApp): Builder

        @BindsInstance
        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponent
    }

    fun inject(application: MovieApp)

}