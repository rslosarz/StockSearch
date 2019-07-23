package com.slosarz.stocksearch.repo

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.slosarz.stocksearch.model.PictureResponse
import com.slosarz.stocksearch.model.SearchPictureResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import org.koin.core.KoinComponent
import org.koin.core.inject

class SearchPictureDataSource : PageKeyedDataSource<Int, PictureResponse>(), KoinComponent {

    private val searchApi: SearchPictureApi by inject()
    private val compositeDisposable = CompositeDisposable()

    var searchTag: String = ""

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PictureResponse>) {
        compositeDisposable += searchApi.getSearchPictureResponse(ApiConstants.PAGE_SIZE)
            .subscribeBy(
                onSuccess = { onLoadInitialSuccess(it, callback) },
                onError = { onLoadDataError(it) }

            )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PictureResponse>) {
        compositeDisposable += searchApi.getSearchPictureResponse(ApiConstants.PAGE_SIZE, params.key, searchTag)
            .subscribe(
                { onLoadAfterSuccess(callback, it, params) },
                { onLoadDataError(it) }
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
