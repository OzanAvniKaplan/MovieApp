package com.ozan.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ozan.movieapp.data.repository.detail.DetailRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory @Inject constructor(private val detailRepository: DetailRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(detailRepository) as T
    }

}