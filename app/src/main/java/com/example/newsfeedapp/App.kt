package com.example.newsfeedapp

import android.app.Application
import com.example.newsfeedapp.di.appModule
import com.example.newsfeedapp.di.dataBaseModule
import com.example.newsfeedapp.features.bokmarks_screen.di.bookmarksModule
import com.example.newsfeedapp.features.main_screen.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, mainScreenModule, dataBaseModule, bookmarksModule)
        }
    }
}