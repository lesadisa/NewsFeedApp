package com.example.feature.domain

import com.example.feature.Base.attempt
import com.example.feature.data.api.NewsRepo
import com.example.feature.domain.model.NewsDomainModel

class NewsInteractor(
    private val newsRepo: NewsRepo
) {
    suspend fun getNews() = attempt { newsRepo.getNews() }
 }