package com.example.assignmentweek7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentweek7.R
import com.example.assignmentweek7.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter() : PagedListAdapter<ResultsItem, RecyclerView.ViewHolder>(ResultsItem().DIIF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is MovieViewHolder) {
            holder.bind(getItem(position))
        }

    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ResultsItem?) {

            itemView.tv_title_movie.text = item?.title
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500${item?.posterPath}")
                .into(itemView.img_movie)

        }

    }
}