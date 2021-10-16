package com.example.newsfeedapp

import android.app.Application
import com.example.feature.di.appModule
import com.example.newsfeedapp.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        //start koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, mainScreenModule)
        }
    }
}