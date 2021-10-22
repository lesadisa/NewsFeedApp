package com.example.feature.data

import com.example.feature.data.api.model.ApiArticleModel
import com.example.feature.data.api.model.ApiSourceModel
import com.example.feature.domain.model.NewsDomainModel
import com.example.feature.domain.model.NewsDomainSourceModel

fun ApiSourceModel.toDomain(): NewsDomainSourceModel = NewsDomainSourceModel(
        id = id,
        name = name,

        )


fun ApiArticleModel.toDomain(): NewsDomainModel =
  NewsDomainModel(
        author = author,
        source = source.toDomain(),
        title = title,
        url = url,
        description = description,
        urlToImage = urlToImage,
        content = content,
        publishedAt = publishedAt
    )



