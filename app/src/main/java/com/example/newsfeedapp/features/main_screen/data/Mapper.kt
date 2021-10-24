package com.example.newsfeedapp.features.main_screen.data

import com.example.newsfeedapp.features.main_screen.data.api.model.ArticleModel
import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel
//Маппинг данных – один из способов для разделения кода приложения на слои.
fun ArticleModel.toDomain() = ArticleDomainModel(
    author = this.author ?: "null",
    title = this.title,
    description = this.description ?: "null",
    url = this.url,
    publishedAt = this.publishedAt,
    urlToImage = this.urlToImage?: "null",
)