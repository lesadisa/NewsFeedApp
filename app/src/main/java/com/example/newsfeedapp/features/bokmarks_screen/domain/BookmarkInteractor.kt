package com.example.newsfeedapp.features.bokmarks_screen.domain

import com.example.newsfeedapp.features.bokmarks_screen.data.BookmarksRepo
import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

class BookmarkInteractor(private val repo: BookmarksRepo) {
    suspend fun create(articleDomainModel: ArticleDomainModel) = repo.create(articleDomainModel)
    suspend fun read() : List<ArticleDomainModel> = repo.read()
    suspend fun update(articleDomainModel: ArticleDomainModel) = repo.update(articleDomainModel)
    suspend fun delete(articleDomainModel: ArticleDomainModel) = repo.delete(articleDomainModel)
}