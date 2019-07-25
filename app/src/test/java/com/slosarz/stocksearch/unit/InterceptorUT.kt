/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.unit

import com.slosarz.stocksearch.network.ApiCompatibilityInterceptor
import com.slosarz.stocksearch.network.ApiConstants
import com.slosarz.stocksearch.network.BaseAuthenticationInterceptor
import com.slosarz.stocksearch.util.NetworkTestUtil.initMockWebServer
import com.slosarz.stocksearch.util.NetworkTestUtil.initOkHttpClientWithInterceptor
import com.slosarz.stocksearch.util.executeCall
import okhttp3.Credentials
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InterceptorUT {

    @Test
    fun `ApiCompatibilityInterceptor adds correct User-Agent header`() {
        val appName = "AppName"
        val interceptor = ApiCompatibilityInterceptor(appName)

        val webServer = initMockWebServer()
        val httpClient = initOkHttpClientWithInterceptor(interceptor)

        httpClient.executeCall(webServer)
        val request = webServer.takeRequest()

        assertEquals(request.getHeader(ApiConstants.HEADER_USER_AGENT), appName)

        webServer.shutdown()
    }

    @Test
    fun `BaseAuthenticationInterceptor adds correct User-Agent header`() {
        val user = "user"
        val password = "password"
        val credentials = Credentials.basic(user, password)
        val interceptor = BaseAuthenticationInterceptor(user, password)

        val webServer = initMockWebServer()
        val httpClient = initOkHttpClientWithInterceptor(interceptor)

        httpClient.executeCall(webServer)
        val request = webServer.takeRequest()

        assertEquals(request.getHeader(ApiConstants.HEADER_AUTHORIZATION), credentials)

        webServer.shutdown()
    }
}
