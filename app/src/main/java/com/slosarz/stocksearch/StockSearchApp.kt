package com.slosarz.stocksearch

import android.app.Application
import com.slosarz.stocksearch.di.DiUtil
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class StockSearchApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@StockSearchApp)
            modules(listOf(DiUtil.networkModule, DiUtil.repositoryModule, DiUtil.appModule))
        }
    }
}
