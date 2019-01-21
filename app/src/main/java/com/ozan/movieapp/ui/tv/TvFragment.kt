package com.ozan.movieapp.ui.tv

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.ozan.movieapp.R
import com.ozan.movieapp.adapter.HorizontalMovieCardsAdapter
import com.ozan.movieapp.adapter.TopRatedMovieAdapter
import com.ozan.movieapp.base.BaseFragment
import com.ozan.movieapp.data.response.tv.popular.PopularTvsResponse
import com.ozan.movieapp.data.response.tv.toprated.TopRatedTvsResponse
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.tv_fragment.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class TvFragment : BaseFragment() {

    companion object {
        fun newInstance() = TvFragment()
    }

    @Inject
    internal lateinit var tvViewModelFactory: TvViewModelFactory

    private lateinit var viewModel: TvViewModel

    private lateinit var topRatedTvAdapter: HorizontalMovieCardsAdapter
    private lateinit var topRatedMovieAdapter: TopRatedMovieAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tv_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, tvViewModelFactory).get(TvViewModel::class.java)

        initUI()
    }

    private fun initUI() = launch {
        val topRatedTvs = viewModel.topRatedTvs.await()
        topRatedTvs.observe(this@TvFragment, Observer { it ->
            if (it == null) {
                return@Observer
            }
            initTopRatedTvsUI(it)
        })

        val popularTvsResponse = viewModel.popularTvs.await()
        popularTvsResponse.observe(this@TvFragment, Observer { it ->
            if (it == null) {
                return@Observer
            }
            initPopularTvsUI(it)
        })

    }

    private fun initTopRatedTvsUI(topRatedTvsResponse: TopRatedTvsResponse) {
        val recyclerView = fr_tv_rv_tvs as RecyclerView
        topRatedTvAdapter = HorizontalMovieCardsAdapter(activity!!, R.layout.row_now_playing, topRatedTvsResponse.results!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = topRatedTvAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initPopularTvsUI(popularTvsResponse: PopularTvsResponse) {
        val recyclerView = fr_tvs_rv_popular as RecyclerView
        topRatedMovieAdapter = TopRatedMovieAdapter(activity!!, R.layout.row_top_rated_movies, popularTvsResponse.results!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = topRatedMovieAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }


}
