/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.repo

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.slosarz.stocksearch.model.PictureResponse
import com.slosarz.stocksearch.model.SearchPictureResponse
import com.slosarz.stocksearch.network.ApiConstants
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class SearchPictureDataSource(
    private val searchApi: SearchPictureApi,
    private val schedulerProvider: SchedulerProvider
) : PageKeyedDataSource<Int, PictureResponse>() {

    private val compositeDisposable = CompositeDisposable()

    private var searchTag: String = ""

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PictureResponse>) {
        compositeDisposable += searchApi.getSearchPictureResponse(ApiConstants.PAGE_SIZE)
            .subscribeOn(schedulerProvider.io())
            .subscribeBy(
                onSuccess = { onLoadInitialSuccess(it, callback) },
                onError = { onLoadDataError(it) }
            )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PictureResponse>) {
        compositeDisposable += searchApi.getSearchPictureResponse(ApiConstants.PAGE_SIZE, params.key, searchTag)
            .subscribeOn(schedulerProvider.io())
            .subscribeBy(
                onSuccess = { onLoadAfterSuccess(callback, it, params) },
                onError = { onLoadDataError(it) }
            )
    }

    override fun invalidate() {
        super.invalidate()
        compositeDisposable.dispose()
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PictureResponse>) {
        //Not used
    }

    private fun onLoadDataError(error: Throwable) {
        //Would be nice to do sth more here like send analytics event and perform retry strategy.
        Log.e("SearchPictureDataSource", "Fetch data", error)
    }

    private fun onLoadInitialSuccess(
        response: SearchPictureResponse,
        callback: LoadInitialCallback<Int, PictureResponse>
    ) {
        searchTag = response.searchId
        //Explicitly set current page to 1 and next page to 2
        callback.onResult(response.data, 1, 2)
    }

    private fun onLoadAfterSuccess(
        callback: LoadCallback<Int, PictureResponse>,
        it: SearchPictureResponse,
        params: LoadParams<Int>
    ) {
        //Increment page key here
        callback.onResult(it.data, params.key + 1)
    }
}
