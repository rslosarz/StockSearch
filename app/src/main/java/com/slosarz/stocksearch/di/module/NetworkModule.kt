package com.slosarz.stocksearch.di.module

import com.slosarz.stocksearch.network.ApiCompatibilityInterceptor
import com.slosarz.stocksearch.network.BaseAuthenticationInterceptor
import com.slosarz.stocksearch.network.ApiConstants
import com.slosarz.stocksearch.repo.SearchPictureApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun provideSearchPictureApi(retrofit: Retrofit): SearchPictureApi {
        return retrofit.create(SearchPictureApi::class.java)
    }

    fun provideBaseAuthenticationInterceptor(): Interceptor {
        //Unsafe credential storage - please refer to README.md
        val username = ApiConstants.USERNAME
        val password = ApiConstants.PASSWORD
        return BaseAuthenticationInterceptor(username, password)
    }

    fun provideApiCompatibilityInterceptor(): Interceptor {
        return ApiCompatibilityInterceptor(ApiConstants.APP_NAME)
    }

    fun provideHttpClient(authentication: Interceptor, apiCompatibility: Interceptor): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(authentication)
        client.addInterceptor(apiCompatibility)
        return client.build()
    }

    fun provideRetrofitInterface(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }
}
