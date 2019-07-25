/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.repo

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.slosarz.stocksearch.R

class GlidePictureLoader : PictureLoader {

    override fun loadPicture(targetView: ImageView, url: String, activity: Activity) {
        //We use Activity to benefit from Glide's "lifecycle aware" feature.
        //Also for that reason we avoid passing activity down to ViewHolder
        Glide.with(activity)
            .load(url)
            .error(R.drawable.placeholder_picture_error)
            .placeholder(R.drawable.placeholder_progress_animation)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(targetView)
    }
}
