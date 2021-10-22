package com.example.newsfeedapp.features.bokmarks_screen.data

import com.example.newsfeedapp.features.bokmarks_screen.data.local.BookmarkDAO
import com.example.newsfeedapp.features.bokmarks_screen.data.local.toDomainModel
import com.example.newsfeedapp.features.bokmarks_screen.data.local.toEntityModel
import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

class BookmarksRepoImpl(private val bookmarkDAO: BookmarkDAO): BookmarksRepo {
    override suspend fun create(articleDomainModel: ArticleDomainModel) {
        bookmarkDAO.create(articleDomainModel.toEntityModel())
    }

    override suspend fun read(): List<ArticleDomainModel> {
        return bookmarkDAO.read().map { it.toDomainModel() }
    }

    override suspend fun update(articleDomainModel: ArticleDomainModel) {
        bookmarkDAO.update(articleDomainModel.toEntityModel())
    }

    override suspend fun delete(articleDomainModel: ArticleDomainModel) {
        bookmarkDAO.delete(articleDomainModel.toEntityModel())
    }
}