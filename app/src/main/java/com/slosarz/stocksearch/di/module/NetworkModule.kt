package com.slosarz.stocksearch.di.module

import com.slosarz.stocksearch.network.ApiCompatibilityInterceptor
import com.slosarz.stocksearch.network.BaseAuthenticationInterceptor
import com.slosarz.stocksearch.repo.ApiConstants
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
        return BaseAuthenticationInterceptor(
            "1ccb9-6f12a-e448c-7cb76-50917-03e0e",
            "8d183-9c539-f6122-a813f-8426f-a68a6"
        )
    }

    fun provideApiCompatibilityInterceptor(): Interceptor {
        return ApiCompatibilityInterceptor("StockSearch")
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
