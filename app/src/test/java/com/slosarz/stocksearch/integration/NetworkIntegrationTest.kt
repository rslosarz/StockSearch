package com.slosarz.stocksearch.integration

import com.slosarz.stocksearch.di.DiUtil
import com.slosarz.stocksearch.network.ApiConstants
import com.slosarz.stocksearch.util.NetworkTestUtil
import com.slosarz.stocksearch.util.executeCall
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(JUnit4::class)
class NetworkIntegrationTest : KoinTest {

    @Before
    fun setUp() {
        startKoin { modules(listOf(DiUtil.networkModule)) }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `configured OkHttpClient adds correct headers to each request`() {
        val httpClient by inject<OkHttpClient>()
        val webServer = NetworkTestUtil.initMockWebServer()

        httpClient.executeCall(webServer)
        val request = webServer.takeRequest()

        assertEquals(request.getHeader(ApiConstants.HEADER_USER_AGENT), ApiConstants.APP_NAME)
        //We do not check exact credentials.
        //Checking values from ApiConstants is pointless as it's not production ready solution
        assert(request.getHeader(ApiConstants.HEADER_USER_AGENT) != null)

        webServer.shutdown()
    }
}
