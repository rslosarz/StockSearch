package com.slosarz.stocksearch.mock

import com.slosarz.stocksearch.model.SearchPictureResponse
import com.slosarz.stocksearch.repo.SearchPictureApi
import io.reactivex.Single

class MockSearchPictureApi : SearchPictureApi {

    override fun getSearchPictureResponse(perPage: Int, page: Int?, searchId: String?): Single<SearchPictureResponse> {
        return if (page == null) {
            Single.fromCallable { MockSearchPictureData.mockPage1SearchPictureResponse }
        } else {
            Single.fromCallable { MockSearchPictureData.mockPage2SearchPictureResponse }
        }
    }
}
