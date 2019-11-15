package dev.ilhamsuaib.app.di

import dev.ilhamsuaib.app.data.PostRepository
import dev.ilhamsuaib.app.data.Preferences
import dev.ilhamsuaib.app.home.PostViewModel
import dev.ilhamsuaib.app.network.NetworkConfig
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by @ilhamsuaib on 2019-11-02.
 * github.com/ilhamsuaib
 */

val dataModule = module {

    single { Preferences(androidContext()) }
}

val networkModule = module {

    single { NetworkConfig.provideHttpClient() }

    single { NetworkConfig.provideRetrofit(get()) }

    single { NetworkConfig.createService(get()) }

}

val repositoryModule = module {

    single { PostRepository(get()) }
}

val viewModelModule = module {

    viewModel { PostViewModel(get()) }
}