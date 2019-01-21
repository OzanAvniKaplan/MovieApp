package com.ozan.movieapp.ui.detail

import android.graphics.Typeface
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozan.movieapp.R
import com.ozan.movieapp.adapter.HorizontalMovieCardsAdapter
import com.ozan.movieapp.base.BaseActivity
import com.ozan.movieapp.data.response.details.credits.CreditsResponse
import com.ozan.movieapp.di.module.IMAGE_URL
import com.ozan.movieapp.utils.GlideApp
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.detail_activity.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("IMPLICIT_CAST_TO_ANY")
class DetailActivity : BaseActivity() {
    private var detailId = 0
    private var isTv = false
    @Inject
    internal lateinit var detailViewModelFactory: DetailViewModelFactory
    private lateinit var viewModel: DetailViewModel
    private lateinit var castAndCrewAdapter: HorizontalMovieCardsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        detailId = intent.getIntExtra("detail_id", 0)
        isTv = intent.getBooleanExtra("is_tv", false)
        viewModel = ViewModelProviders.of(this, detailViewModelFactory).get(DetailViewModel::class.java)
        viewModel.id = detailId
        ac_details_iv_back.setOnClickListener { finish() }
        ac_details_tv_back.setOnClickListener{ finish() }
        initUI(isTv)
    }

    private fun initUI(isTv: Boolean) = when {
        isTv -> initTv()
        else -> initMovie()
    }

    private fun initTv() = launch {
        val tvDetail = viewModel.tvDetail.await()
        tvDetail.observeForever(Observer { it ->
            if (it == null) {
                return@Observer
            }
            var genres = ""
            it.genres!!.forEach {
                genres = genres + " " + it!!.name
            }
            initDetails(it.posterPath, it.overview, it.name, it.voteAverage, it.backdropPath.toString(), genres)
        })

        val tvCredits = viewModel.tvCredits.await()
        tvCredits.observeForever(Observer { it ->
            if (it == null) {
                return@Observer
            }
            initCredits(it)
        })

    }

    private fun initMovie() = launch {
        val movieDetail = viewModel.movieDetail.await()
        movieDetail.observeForever(Observer { it ->
            if (it == null) {
                return@Observer
            } else {
                var genres = ""
                it.genres!!.forEach {
                    genres = genres + " " + it!!.name
                }
                initDetails(it.posterPath, it.overview, it.title, it.voteAverage, it.backdropPath!!, genres)
            }
        })

        val movieCredits = viewModel.movieCredits.await()
        movieCredits.observeForever(Observer { it ->
            if (it == null) {
                return@Observer
            }
            initCredits(it)
        })

    }

    private fun initCredits(creditsResponse: CreditsResponse) {
        val recyclerView = ac_details_rv_cast_crew as RecyclerView
        castAndCrewAdapter = HorizontalMovieCardsAdapter(this, R.layout.row_cast_and_crew, creditsResponse.cast!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = castAndCrewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun initDetails(poster: String?, description: String?, title: String?, rate: Double?, backdropPath: String, genres: String) {
        GlideApp.with(applicationContext).load(IMAGE_URL + poster).into(ac_details_iv_poster)
        GlideApp.with(applicationContext).load(IMAGE_URL + backdropPath).into(ac_details_iv_trailer)
        ac_details_tv_type.text = genres
        ac_details_tv_description.text = description
        ac_details_tv_title.text = title!!.toUpperCase()
        ac_details_tv_title.setTypeface(null, Typeface.BOLD)
        ac_details_rating_bar.rating = rate?.toFloat()!! / 2f
        ac_details_tv_rate.text = rate.toString().substring(0,1)
        ac_details_tv_rate.setTypeface(null, Typeface.BOLD)
        ac_details_tv_float_rate.text = rate.toString().substring(1,3)
        ac_details_tv_float_rate.setTypeface(null, Typeface.BOLD)

    }

}

