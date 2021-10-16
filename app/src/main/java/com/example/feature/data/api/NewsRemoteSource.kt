package com.example.feature.data.api

import com.example.feature.data.api.model.ApiResponseObject

class NewsRemoteSource(private val newsApi: NewsApiClient) {

    fun getNews(): ApiResponseObject {
        return newsApi.getNews()
    }
}