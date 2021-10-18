package com.example.feature.data.api

import com.example.feature.data.toDomain
import com.example.feature.domain.model.NewsDomainModel

class NewsRepoImpl(private val newsRemoteSource: NewsRemoteSource) : NewsRepo {
    override fun getNews(): List<NewsDomainModel> {
        return newsRemoteSource.getNews().listArticleModel.map { it.toDomain() }
    }
}