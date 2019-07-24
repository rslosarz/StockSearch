package com.slosarz.stocksearch.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.slosarz.stocksearch.model.PictureResponse
import com.slosarz.stocksearch.repo.ApiConstants
import com.slosarz.stocksearch.repo.SearchPictureFactory

class SearchViewModel(private val searchPictureFactory: SearchPictureFactory) : ViewModel() {

    fun getPictureData(): LiveData<PagedList<PictureResponse>> {
        val pagedListConfig = buildPageListConfig()
        return LivePagedListBuilder(searchPictureFactory, pagedListConfig)
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
