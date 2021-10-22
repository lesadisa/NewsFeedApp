package com.example.feature.di

import com.example.feature.const.HttpRes
import com.example.feature.const.HttpRes.BASE_URL
import com.example.feature.data.api.NewsApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<OkHttpClient> {
        val httpLogging = HttpLoggingInterceptor()
        httpLogging.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder()
            .addInterceptor(httpLogging)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(HttpRes.BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<NewsApiClient> {
        get<Retrofit>().create(NewsApiClient::class.java)
    }
}