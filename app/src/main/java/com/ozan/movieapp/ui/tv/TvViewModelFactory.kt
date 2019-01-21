package com.ozan.movieapp.ui.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ozan.movieapp.data.repository.tv.TvRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class TvViewModelFactory @Inject constructor(private val repository: TvRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvViewModel(repository) as T
    }

}