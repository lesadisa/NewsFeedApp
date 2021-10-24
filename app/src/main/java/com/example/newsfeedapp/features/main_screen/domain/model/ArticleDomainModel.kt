package com.example.newsfeedapp.features.main_screen.domain.model

data class ArticleDomainModel(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val publishedAt: String,
    val urlToImage: String
)
