package com.example.feature.data.api.model

import com.google.gson.annotations.SerializedName

data class ApiArticleModel (

    @SerializedName("source")
    val source: ApiSourceModel,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("content") // на Github отсутствует
    val content: String,
)

