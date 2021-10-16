package com.example.newsfeedapp.di

import com.example.feature.data.api.NewsApiClient
import com.example.feature.data.api.NewsRemoteSource
import com.example.feature.data.api.NewsRepo
import com.example.feature.data.api.NewsRepoImpl
import com.example.feature.domain.NewsInteractor
import com.example.newsfeedapp.features.main_screen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit

val mainScreenModule = module {

    viewModel {
        MainScreenViewModel()
    }

    single { NewsInteractor(get()) }

    single<NewsRepo> { NewsRepoImpl(get()) }

    single { NewsRemoteSource(get()) }

    single { get<Retrofit>().create(NewsApiClient::class.java) }

}