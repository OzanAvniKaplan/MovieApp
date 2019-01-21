package com.ozan.movieapp.ui.tv

import androidx.lifecycle.ViewModel
import com.ozan.movieapp.data.repository.tv.TvRepository
import com.ozan.movieapp.utils.lazyDeferred
import javax.inject.Inject

class TvViewModel  @Inject constructor(tvRepository: TvRepository) : ViewModel() {

    val topRatedTvs by lazyDeferred {
        tvRepository.getTopRatedTvs()
    }
    val popularTvs by lazyDeferred {
        tvRepository.getPopularTvs()
    }

}
