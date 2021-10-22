package com.example.feature.data.api

import com.example.feature.const.HttpRes
import com.example.feature.data.api.model.ApiNewsModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.*

interface NewsApiClient {

    @GET(HttpRes.NEWS_PATH)
    @Headers("X-Api-Key: 672c4b70da7240ad9f843d026f62adfa")
    suspend fun getNews(
              @Query("country") language: String = Locale.getDefault().country
    ): ApiNewsModel

}