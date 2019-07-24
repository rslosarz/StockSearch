package com.slosarz.stocksearch.repo

object ApiConstants {
    const val BASE_URL = "https://api.shutterstock.com/v2/"
    const val SEARCH_ENDPOINT = "images/search"

    const val HEADER_AUTHORIZATION = "Authorization"
    const val HEADER_USER_AGENT = "User-Agent"

    //Storing crucial data like this is unacceptable. It's left like this due to time constraint.
    //Normally I'd use oAuth2 based authorization with secret and clientId kept on safe token server.
    //Acceptable solution is also to use NDK and pass those values via C-based methods to CharSequence objects.
    //Also I kept it here to make it easier to change in case my subscription on Shutterstock expires
    val USERNAME: CharSequence by lazy { "1ccb9-6f12a-e448c-7cb76-50917-03e0e" }
    val PASSWORD: CharSequence by lazy { "8d183-9c539-f6122-a813f-8426f-a68a6" }

    const val APP_NAME = "StockSearch"

    const val PAGE_SIZE = 20
}
