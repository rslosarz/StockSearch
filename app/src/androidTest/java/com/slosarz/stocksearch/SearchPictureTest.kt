/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.slosarz.stocksearch.mock.MockPictureLoader
import com.slosarz.stocksearch.mock.MockSearchPictureApi
import com.slosarz.stocksearch.repo.PictureLoader
import com.slosarz.stocksearch.repo.SchedulerProvider
import com.slosarz.stocksearch.repo.SearchPictureApi
import com.slosarz.stocksearch.repo.TrampolineSchedulerProvider
import com.slosarz.stocksearch.screen.SearchActivity
import com.slosarz.stocksearch.util.UiTestUtil.withViewAtPosition
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class SearchPictureTest : KoinTest {

    @get:Rule
    val rule = ActivityTestRule(SearchActivity::class.java, false, false)

    @Before
    fun setUp() {
        loadKoinModules(listOf(module {
            single<SchedulerProvider>(override = true) { TrampolineSchedulerProvider() }
            single<SearchPictureApi>(override = true) { MockSearchPictureApi() }
            single<PictureLoader>(override = true) { MockPictureLoader() }
        }))
    }

    /**
     * This test is very naive due to time constraints.
     */
    @Test
    fun displaysFirstItem() {
        rule.launchActivity(null)
        onView(withId(R.id.pictureList))
            .check(matches(withViewAtPosition(1, isDisplayed())))
    }
}
