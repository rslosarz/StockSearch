package com.slosarz.stocksearch.network

import com.slosarz.stocksearch.repo.ApiConstants
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BaseAuthenticationInterceptor(user: String, password: String) : Interceptor {

    private val credentials: String = Credentials.basic(user, password)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request
            .newBuilder()
            .header(ApiConstants.HEADER_AUTHORIZATION, credentials)
            .build()
        return chain.proceed(authenticatedRequest)
    }
}
