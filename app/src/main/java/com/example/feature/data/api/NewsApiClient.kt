package com.example.feature.data.api

import com.example.feature.data.api.model.ApiResponseObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApiClient {

    @GET("everything")
    @Headers("X-Api-Key: 672c4b70da7240ad9f843d026f62adfa")
    fun getNews(
        @Query("q") word: String = "",
        @Query("language") language: String = "ru",
        @Query("country") country: String = "ru"
    ): ApiResponseObject

}