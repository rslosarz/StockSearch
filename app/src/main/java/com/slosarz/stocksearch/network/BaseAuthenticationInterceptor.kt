package com.slosarz.stocksearch.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BaseAuthenticationInterceptor(user: CharSequence, password: CharSequence) : Interceptor {

    private val credentials: String = Credentials.basic(user.toString(), password.toString())

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request
            .newBuilder()
            .header(ApiConstants.HEADER_AUTHORIZATION, credentials)
            .build()
        return chain.proceed(authenticatedRequest)
    }
}
