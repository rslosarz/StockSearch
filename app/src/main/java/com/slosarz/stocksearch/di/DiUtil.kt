package com.slosarz.stocksearch.di

import com.slosarz.stocksearch.di.module.NetworkModule
import com.slosarz.stocksearch.repo.SearchPictureFactory
import com.slosarz.stocksearch.screen.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DiUtil {
    val networkModule = module {
        single(named("authenticator")) { NetworkModule.provideBaseAuthenticationInterceptor() }
        single(named("apiCompatibility")) { NetworkModule.provideApiCompatibilityInterceptor() }
        single { NetworkModule.provideHttpClient(get(named("authenticator")), get(named("apiCompatibility"))) }
        single { NetworkModule.provideRetrofitInterface(get()) }
        single { NetworkModule.provideSearchPictureApi(get()) }
    }

    val repositoryModule = module {
        factory { SearchPictureFactory() }
    }

    val appModule = module {
        viewModel { SearchViewModel(get()) }
    }
}
