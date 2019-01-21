package com.ozan.movieapp.ui.movie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.ozan.movieapp.base.BaseFragment
import com.ozan.movieapp.data.response.movie.nowplaying.NowPlayingResponse
import com.ozan.movieapp.data.response.movie.popular.PopularMoviesResponse
import com.ozan.movieapp.data.response.movie.toprated.TopRatedMoviesResponse
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.movie_fragment.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozan.movieapp.R
import com.ozan.movieapp.adapter.HorizontalMovieCardsAdapter
import com.ozan.movieapp.adapter.TopRatedMovieAdapter

class MovieFragment : BaseFragment() {

    companion object {
        fun newInstance() = MovieFragment()
    }

    @Inject
    internal lateinit var movieViewModelFactory: MovieViewModelFactory

    private lateinit var viewModel: MovieViewModel

    private lateinit var popularMovieAdapter: HorizontalMovieCardsAdapter
    private lateinit var nowPlayingMovieAdapter: HorizontalMovieCardsAdapter
    private lateinit var topRatedMovieAdapter: TopRatedMovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, movieViewModelFactory)
            .get(MovieViewModel::class.java)

        initUI()
    }

    private fun initUI() = launch {
        //TopRatedMovies type of LiveData<TopRatedMoviesResponse> and observer
        val topRatedMovies = viewModel.topRatedMovies.await()
        topRatedMovies.observe(this@MovieFragment, Observer { it ->
            if (it == null) {
                return@Observer
            }
            initTopRatedUI(it)
        })

        //TopRatedMovies type of LiveData<TopRatedMoviesResponse> and observer
        val nowPlaying = viewModel.nowPlaying.await()
        nowPlaying.observe(this@MovieFragment, Observer { it ->
            if (it == null) {
                return@Observer
            }
            initNowPlayingUI(it)
        })

        //PopularMoviesResponse type of LiveData<PopularMoviesResponse> and observer
        val popularMoviesResponse = viewModel.popularMovies.await()
        popularMoviesResponse.observe(this@MovieFragment, Observer { it ->
            if (it == null) {
                return@Observer
            }
            initPopularMoviesUI(it)
        })

    }

    private fun initTopRatedUI(topRatedMoviesResponse: TopRatedMoviesResponse) {
        val recyclerView = fr_movies_rv_top_rated as RecyclerView
        topRatedMovieAdapter = TopRatedMovieAdapter(activity!!, R.layout.row_top_rated_movies, topRatedMoviesResponse.results!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = topRatedMovieAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initNowPlayingUI(nowPlayingResponse: NowPlayingResponse) {
        val recyclerView = fr_movies_rv_now_playing as RecyclerView
        nowPlayingMovieAdapter = HorizontalMovieCardsAdapter(activity!!, R.layout.row_now_playing, nowPlayingResponse.results!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = nowPlayingMovieAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initPopularMoviesUI(popularMoviesResponse: PopularMoviesResponse) {
        val recyclerView = fr_movies_rv_popular as RecyclerView
        popularMovieAdapter = HorizontalMovieCardsAdapter(activity!!, R.layout.row_now_playing, popularMoviesResponse.results!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = popularMovieAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

}
