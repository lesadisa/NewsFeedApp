package com.example.newsfeedapp.features.main_screen.di

import com.example.newsfeedapp.features.bokmarks_screen.domain.BookmarkInteractor
import com.example.newsfeedapp.features.main_screen.data.api.NewsApi
import com.example.newsfeedapp.features.main_screen.data.api.NewsRemoteSource
import com.example.newsfeedapp.features.main_screen.data.api.NewsRepository
import com.example.newsfeedapp.features.main_screen.data.api.NewsRepositoryImpl
import com.example.newsfeedapp.features.main_screen.domain.NewsInteractor
import com.example.newsfeedapp.features.main_screen.ui.MainScreenViewModel
import okhttp3.OkHttpClient
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://newsapi.org/v2/everything?q=bitcoin&apiKey=66147346f2a941369d369f9f9eeff6d9
const val BASE_URL = "https://newsapi.org/"
val mainScreenModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<NewsApi> {
        get<Retrofit>().create(NewsApi::class.java)
    }

    single<NewsRemoteSource> {
        NewsRemoteSource(get<NewsApi>())
    }

    single<NewsRepository> {
        NewsRepositoryImpl(get<NewsRemoteSource>())
    }

    single<NewsInteractor> {
        NewsInteractor(get<NewsRepository>())
    }

    viewModel {
        MainScreenViewModel(get<NewsInteractor>(), get<BookmarkInteractor>())
    }
}