package com.slosarz.stocksearch.di

import com.slosarz.stocksearch.di.module.NetworkModule
import com.slosarz.stocksearch.repo.*
import com.slosarz.stocksearch.screen.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Util defining DI modules
 * I'm using Koin here instead of Dagger2. For reasoning please refer to README.md
 */
object DiUtil {
    val networkModule = module {
        single<SchedulerProvider> { ProductionSchedulerProvider() }
        single(named("authenticator")) { NetworkModule.provideBaseAuthenticationInterceptor() }
        single(named("apiCompatibility")) { NetworkModule.provideApiCompatibilityInterceptor() }
        single { NetworkModule.provideHttpClient(get(named("authenticator")), get(named("apiCompatibility"))) }
        single { NetworkModule.provideRetrofitInterface(get()) }
        single { NetworkModule.provideSearchPictureApi(get()) }
        single<PictureLoader> { GlidePictureLoader() }
    }

    val repositoryModule = module {
        factory { SearchPictureFactory(get(), get()) }
    }

    val appModule = module {
        viewModel { SearchViewModel(get()) }
    }
}
