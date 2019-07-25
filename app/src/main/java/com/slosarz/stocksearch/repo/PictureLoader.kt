/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.repo

import android.app.Activity
import android.widget.ImageView

interface PictureLoader {
    fun loadPicture(targetView: ImageView, url: String, activity: Activity)
}
