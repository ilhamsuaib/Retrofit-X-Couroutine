package dev.ilhamsuaib.app

import android.app.Application
import dev.ilhamsuaib.app.di.dataModule
import dev.ilhamsuaib.app.di.networkModule
import dev.ilhamsuaib.app.di.repositoryModule
import dev.ilhamsuaib.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            androidLogger(Level.ERROR)
            modules(listOf(dataModule, networkModule, repositoryModule, viewModelModule))
        }
    }
}