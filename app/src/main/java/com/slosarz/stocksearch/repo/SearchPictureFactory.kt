package com.slosarz.stocksearch.repo

import androidx.paging.DataSource
import com.slosarz.stocksearch.model.PictureResponse

class SearchPictureFactory(
    private val searchPictureApi: SearchPictureApi,
    private val schedulerProvider: SchedulerProvider
) : DataSource.Factory<Int, PictureResponse>() {

    override fun create(): DataSource<Int, PictureResponse> {
        return SearchPictureDataSource(searchPictureApi, schedulerProvider)
    }
}
