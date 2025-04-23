package dev.vincenzocostagliola.coinswatch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.vincenzocostagliola.coinswatch.LoggingSetup.setupLogging

@HiltAndroidApp
class CoinSwatchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupLogging()
    }
}