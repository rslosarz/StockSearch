/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.unit

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.slosarz.stocksearch.mock.MockSearchPictureResponse
import com.slosarz.stocksearch.model.PictureResponse
import com.slosarz.stocksearch.network.ApiConstants
import com.slosarz.stocksearch.repo.SearchPictureApi
import com.slosarz.stocksearch.repo.SearchPictureFactory
import com.slosarz.stocksearch.repo.TrampolineSchedulerProvider
import com.slosarz.stocksearch.screen.SearchViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.slot
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.test.KoinTest

@RunWith(JUnit4::class)
class SearchViewModelUT : KoinTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var observer: Observer<PagedList<PictureResponse>>

    @RelaxedMockK
    lateinit var searchPictureApi: SearchPictureApi

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `First page fetch`() {
        val searchPictureFactory = SearchPictureFactory(searchPictureApi, TrampolineSchedulerProvider())
        val viewModel = SearchViewModel(searchPictureFactory)
        val page1 = MockSearchPictureResponse.mockPage1SearchPictureResponse

        every { searchPictureApi.getSearchPictureResponse(ApiConstants.PAGE_SIZE) }.returns(Single.just(page1))
        val slot = slot<PagedList<PictureResponse>>()
        every { observer.onChanged(capture(slot)) }.answers { }

        viewModel.pictureData.observeForever(observer)

        assertEquals(slot.captured, page1.data)
    }

    //It would be useful to create test object extending SearchPictureDataSource
    //and overriding some methods to enable test force of downloading another page.
    //I didn't have enough time though to do that.
    //In sake of checking the sequence of elements from onChanged,
    //we can simply create mutable list and add following items to it in
    //`every { observer.onChanged(capture(slot)) }.answers { <HERE> }`
}
