package com.example.newsfeedapp.features.main_screen.data.api

import com.example.newsfeedapp.features.main_screen.data.api.model.NewsModel
import com.example.newsfeedapp.features.main_screen.data.api.model.SourceModel

class NewsRemoteSource(private val api: NewsApi) {
    suspend fun getNews(): NewsModel {
        return api.getTopHeadlines()
    }
}