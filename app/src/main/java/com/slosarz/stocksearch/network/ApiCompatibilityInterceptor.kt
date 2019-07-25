/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiCompatibilityInterceptor(private val appName: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request
            .newBuilder()
            .header(ApiConstants.HEADER_USER_AGENT, appName)
            .build()
        return chain.proceed(authenticatedRequest)
    }
}
