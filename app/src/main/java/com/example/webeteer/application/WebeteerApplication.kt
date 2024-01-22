package com.example.webeteer.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WebeteerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}