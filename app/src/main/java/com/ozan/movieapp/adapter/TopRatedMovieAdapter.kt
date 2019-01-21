package com.ozan.movieapp.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozan.movieapp.MainActivity
import com.ozan.movieapp.data.response.movie.toprated.TopRatedMoviesResultsItem
import com.ozan.movieapp.data.response.tv.popular.PopularTvsResultsItem
import com.ozan.movieapp.di.module.IMAGE_URL
import com.ozan.movieapp.ui.detail.DetailActivity
import com.ozan.movieapp.utils.GlideApp
import kotlinx.android.synthetic.main.row_now_playing.view.*

class TopRatedMovieAdapter(@get:JvmName("getContext_")
    internal val context: Context, private val resource: Int,
                           private val list: List<*>
) : RecyclerView.Adapter<TopRatedMovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return MyViewHolder(v)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.row_iv_cover!!
        val textView = view.row_tv_movie_title!!
        val rlRate = view.row_rl_rate!!
        val rate = view.row_rate!!
        val floatRate = view.row_float_rate!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        when (item) {
            is TopRatedMoviesResultsItem -> setItemUI(holder, item.title!!, item.backdropPath!!, true, item.id!!, false, false,false, false, item.voteAverage!!)
            is PopularTvsResultsItem -> setItemUI(holder, item.name!!, item.backdropPath!!, true, item.id!!, true, false,true, true, item.voteAverage!!)
        }
    }

    private fun setItemUI(
        holder: MyViewHolder,
        title: String,
        imageUrl: String,
        hasDetail: Boolean,
        detailId: Int,
        isTv: Boolean,
        isUpperCase: Boolean,
        isVisibleTitle: Boolean,
        isPopularTvs: Boolean,
        voteAverage: Double
    ) {
        if (isUpperCase) holder.textView.text = title.toUpperCase()
        else holder.textView.text = title
        holder.textView.setTypeface(null, Typeface.BOLD)
        if (isPopularTvs){
            holder.rlRate.visibility = View.VISIBLE
            holder.rate.text = voteAverage.toString().substring(0,1)
            holder.rate.setTypeface(null, Typeface.BOLD)
            holder.floatRate.text = voteAverage.toString().substring(1,3)
            holder.floatRate.setTypeface(null, Typeface.BOLD)
        }
        GlideApp.with(context).load(IMAGE_URL + imageUrl).into(holder.imageView)
        if (hasDetail) {
            holder.imageView.setOnClickListener {
                context as MainActivity
                val i = Intent(context, DetailActivity::class.java)
                i.putExtra("detail_id", detailId)
                i.putExtra("is_tv", isTv)
                context.startActivity(i)
            }
        }
        if (!isVisibleTitle){
            holder.textView.visibility = View.GONE
        }
    }

    override fun getItemCount() = list.size

}