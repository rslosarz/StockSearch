/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.slosarz.stocksearch.model.PictureResponse
import com.slosarz.stocksearch.network.ApiConstants
import com.slosarz.stocksearch.repo.SearchPictureFactory

class SearchViewModel(private val searchPictureFactory: SearchPictureFactory) : ViewModel() {

    val pictureData: LiveData<PagedList<PictureResponse>> by lazy {
        LivePagedListBuilder(searchPictureFactory, buildPageListConfig())
            .build()
    }

    private fun buildPageListConfig(): PagedList.Config {
        return PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(ApiConstants.PAGE_SIZE)
            .setPageSize(ApiConstants.PAGE_SIZE)
            .build()
    }
}
