package com.slosarz.stocksearch.screen

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.slosarz.stocksearch.R
import com.slosarz.stocksearch.model.PictureResponse
import com.slosarz.stocksearch.repo.PictureLoader
import kotlinx.android.synthetic.main.item_picture.view.*

class PictureAdapter(private val activity: Activity, private val pictureLoader: PictureLoader) :
    PagedListAdapter<PictureResponse, PictureViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_picture, parent, false)
        return PictureViewHolder(view)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        getItem(position)?.let {
            pictureLoader.loadPicture(holder.itemView.pictureView, it.assets.preview.url, activity)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PictureResponse>() {

            override fun areItemsTheSame(
                old: PictureResponse,
                new: PictureResponse
            ) = old.id == new.id

            override fun areContentsTheSame(
                old: PictureResponse,
                new: PictureResponse
            ) = old == new
        }
    }
}

class PictureViewHolder(view: View) : RecyclerView.ViewHolder(view)
