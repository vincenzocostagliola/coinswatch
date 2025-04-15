package dev.vincenzocostagliola.coinswatch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoinSwatchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        this.setupLogging()
    }
}