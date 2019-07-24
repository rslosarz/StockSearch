package com.slosarz.stocksearch.repo

import com.slosarz.stocksearch.model.SearchPictureResponse
import com.slosarz.stocksearch.network.ApiConstants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchPictureApi {

    @GET(ApiConstants.SEARCH_ENDPOINT)
    fun getSearchPictureResponse(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int? = null,
        @Query("search_id") searchId: String? = null
    ): Single<SearchPictureResponse>
}
