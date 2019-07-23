package com.slosarz.stocksearch.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.slosarz.stocksearch.model.PictureResponse
import com.slosarz.stocksearch.repo.ApiConstants
import com.slosarz.stocksearch.repo.SearchPictureFactory

class SearchViewModel(private val searchPictureFactory: SearchPictureFactory) : ViewModel() {

    lateinit var data: LiveData<PagedList<PictureResponse>>

    init {
        initializePaging()
    }

    private fun initializePaging() {

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(ApiConstants.PAGE_SIZE)
            .setPageSize(ApiConstants.PAGE_SIZE)
            .build()

        data = LivePagedListBuilder(searchPictureFactory, pagedListConfig)
            .build()
    }
}