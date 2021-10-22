package com.example.feature.domain.model

import com.google.gson.annotations.SerializedName

data class NewsDomainModel(
    val source: NewsDomainSourceModel,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)