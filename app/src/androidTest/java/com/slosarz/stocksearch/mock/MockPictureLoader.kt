/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.mock

import android.app.Activity
import android.widget.ImageView
import com.slosarz.stocksearch.R
import com.slosarz.stocksearch.repo.PictureLoader

/**
 * PictureLoader implementation used in UI tests to display placeholder image
 */
class MockPictureLoader : PictureLoader {

    override fun loadPicture(targetView: ImageView, url: String, activity: Activity) {
        targetView.setImageResource(R.drawable.placeholder_picture_error)
    }
}
