package com.example.feature.data.api.model

import com.google.gson.annotations.SerializedName

data class ApiNewsModel(
    @SerializedName("totalResults")
    val totalResults: Long,
    @SerializedName("source")
    val listArticleModel: List<ApiArticleModel>)