/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.model

import com.google.gson.annotations.SerializedName

data class SearchPictureResponse(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("search_id")
    val searchId: String,
    val data: List<PictureResponse>
)
