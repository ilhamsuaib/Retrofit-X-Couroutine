package dev.ilhamsuaib.app

import android.app.Application
import dev.ilhamsuaib.app.network.ApiService
import dev.ilhamsuaib.app.network.NetworkConfig

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

class MyApp : Application() {

    companion object {
        lateinit var service: ApiService
    }

    override fun onCreate() {
        super.onCreate()

        service = NetworkConfig.createService()
    }
}