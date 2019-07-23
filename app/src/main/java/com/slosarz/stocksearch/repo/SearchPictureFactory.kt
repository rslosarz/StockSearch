package com.slosarz.stocksearch.repo

import androidx.paging.DataSource
import com.slosarz.stocksearch.model.PictureResponse

class SearchPictureFactory : DataSource.Factory<Int, PictureResponse>() {

    override fun create(): DataSource<Int, PictureResponse> {
        return SearchPictureDataSource()
    }
}
