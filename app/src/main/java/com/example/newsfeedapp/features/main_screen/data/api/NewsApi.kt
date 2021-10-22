package com.example.newsfeedapp.features.main_screen.data.api

import com.example.newsfeedapp.features.main_screen.data.api.model.NewsModel
import com.example.newsfeedapp.features.main_screen.data.api.model.SourceModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String = "66147346f2a941369d369f9f9eeff6d9",
        @Query("country") country: String = "ru"
//        @Query("q") keyWords: String?
    ): NewsModel
}