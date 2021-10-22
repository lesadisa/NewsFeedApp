package com.example.feature.data.api

import com.example.feature.data.api.model.ApiNewsModel
import com.example.feature.data.api.model.ApiSourceModel

class NewsRemoteSource(private val newsApi: NewsApiClient) {

        suspend fun getNews(): ApiNewsModel = newsApi.getNews()

}