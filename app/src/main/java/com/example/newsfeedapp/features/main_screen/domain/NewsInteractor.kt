package com.example.newsfeedapp.features.main_screen.domain

import com.example.newsfeedapp.Base.attempt
import com.example.newsfeedapp.features.main_screen.data.api.NewsRepository

class NewsInteractor(private val repository: NewsRepository) {
    suspend fun getNews() = attempt { repository.getNews() }
}