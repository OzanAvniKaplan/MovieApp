package com.ozan.movieapp.ui.detail

import androidx.lifecycle.ViewModel;
import com.ozan.movieapp.data.repository.detail.DetailRepository
import com.ozan.movieapp.utils.lazyDeferred
import javax.inject.Inject

class DetailViewModel @Inject constructor(detailRepository: DetailRepository) : ViewModel() {

    var id: Int = 0

    fun setDetailId(id: Int) {
        this.id = id
    }

    val movieCredits by lazyDeferred {
        detailRepository.getMovieCredits(id)
    }
    val movieDetail by lazyDeferred {
        detailRepository.getMovieDetail(id)
    }
    val tvCredits by lazyDeferred {
        detailRepository.getTvCredits(id)
    }
    val tvDetail by lazyDeferred {
        detailRepository.getTvDetail(id)
    }

}
