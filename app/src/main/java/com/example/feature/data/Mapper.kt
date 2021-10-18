package com.example.feature.data

import com.example.feature.data.api.model.ApiArticleModel
import com.example.feature.data.api.model.ApiSourceModel
import com.example.feature.domain.model.NewsDomainModel
import com.example.feature.domain.model.NewsDomainSourceModel

fun ApiSourceModel.toDomain(): NewsDomainSourceModel {
    return NewsDomainSourceModel(
        id = id,
        name = name,

        )
}

fun ApiArticleModel.toDomain(): NewsDomainModel {
    return NewsDomainModel(
        author = author,
        source = source.toDomain(),
        title = title,
        url = url,
        description = description,
        urlToImage = urlToImage,
        content = content,
        publishedAt = publishedAt
    )
}


/*
 @SerializedName("description")
val description: String?,

@SerializedName("url")
val url: String?,

@SerializedName("category")
val category: String?,

@SerializedName("language")
val language: String?,

@SerializedName("country")
val country: String?,
 */