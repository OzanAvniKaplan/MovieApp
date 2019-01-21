package com.ozan.movieapp.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozan.movieapp.MainActivity
import com.ozan.movieapp.data.response.details.credits.CastItem
import com.ozan.movieapp.data.response.movie.nowplaying.NowPlayingResultsItem
import com.ozan.movieapp.data.response.movie.popular.PopularMoviesResultsItem
import com.ozan.movieapp.data.response.tv.toprated.TopRatedTvsResultsItem
import com.ozan.movieapp.di.module.IMAGE_URL
import com.ozan.movieapp.ui.detail.DetailActivity
import com.ozan.movieapp.utils.GlideApp
import kotlinx.android.synthetic.main.row_now_playing.view.*
import java.lang.Exception

class HorizontalMovieCardsAdapter(
    @get:JvmName("getContext_") private val context: Context, private val resource: Int,
    private val list: List<*>
) : RecyclerView.Adapter<HorizontalMovieCardsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return MyViewHolder(v)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.row_tv_movie_title!!
        val imageView = view.row_iv_cover!!
        val rlRate = view.row_rl_rate!!
        val rate = view.row_rate!!
        val floatRate = view.row_float_rate!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        when (item) {
            is NowPlayingResultsItem -> setItemUI(holder, item.title, item.posterPath, true, item.id, false, true, false, item.voteAverage!!)
            is PopularMoviesResultsItem -> setItemUI(holder, item.title, item.posterPath, true, item.id, false, true, true, item.voteAverage!!)
            is TopRatedTvsResultsItem -> setItemUI(holder, item.name, item.posterPath, true, item.id, true, true, false, item.voteAverage!!)
            is CastItem -> setItemUI(holder, item.name!!, item.profilePath, false, item.id, false, false, false, 0.0)
        }
    }

    override fun getItemCount() = list.size

    private fun setItemUI(holder: MyViewHolder, title: String?, imageUrl: String?, hasDetail: Boolean, detailId: Int?, isTv: Boolean, isUpperCase: Boolean, isPopularMovie: Boolean, voteAverage: Double) {
        try {
            if (title != null) {
                if (isUpperCase) holder.textView.text = title.toUpperCase()
                else holder.textView.text = title
                holder.textView.setTypeface(null, Typeface.BOLD)
            }
            if (imageUrl != null) {
                GlideApp.with(context).load(IMAGE_URL + imageUrl).into(holder.imageView)
            }
            if (hasDetail && detailId != null) {
                holder.imageView.setOnClickListener {
                    context as MainActivity
                    val i = Intent(context, DetailActivity::class.java)
                    i.putExtra("detail_id", detailId)
                    i.putExtra("is_tv", isTv)
                    context.startActivity(i)
                }
            }
            if (isPopularMovie) {
                holder.rlRate.visibility = View.VISIBLE
                holder.rate.text = voteAverage.toString().substring(0, 1)
                holder.rate.setTypeface(null, Typeface.BOLD)
                holder.floatRate.text = voteAverage.toString().substring(1, 3)
                holder.floatRate.setTypeface(null, Typeface.BOLD)
            }
        } catch (e: Exception) {
            Log.e(this.javaClass.simpleName, e.message)
        }
    }

}
