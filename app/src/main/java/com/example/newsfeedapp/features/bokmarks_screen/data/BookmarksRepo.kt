package com.example.newsfeedapp.features.bokmarks_screen.data

import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

interface BookmarksRepo {
    suspend fun create(articleDomainModel: ArticleDomainModel)
    suspend fun read() : List<ArticleDomainModel>
    suspend fun update(articleDomainModel: ArticleDomainModel)
    suspend fun delete(articleDomainModel: ArticleDomainModel)
}