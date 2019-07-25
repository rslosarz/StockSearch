/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.util

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

object NetworkTestUtil {

    fun initMockWebServer() =
        MockWebServer().apply {
            start()
            enqueue(MockResponse())
        }

    fun initOkHttpClientWithInterceptor(interceptor: Interceptor) =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build()

    fun provideMockRequest(webServer: MockWebServer) =
        Request.Builder().url(webServer.url("/")).build()
}

fun OkHttpClient.executeCall(webServer: MockWebServer) {
    newCall(NetworkTestUtil.provideMockRequest(webServer))
        .execute()
}
