package com.example.newsfeedapp.features.bokmarks_screen.data.local

import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

fun ArticleDomainModel.toEntityModel() = BookmarksEntity(
    url = url,
    author = author,
    imageUrl = urlToImage ?: "",
    title = title,
    description = description,
    publishedAt = publishedAt
)

fun BookmarksEntity.toDomainModel() = ArticleDomainModel(
    url = url,
    author = author,
    title = title,
    description = description,
    publishedAt = publishedAt,
    urlToImage = imageUrl

)