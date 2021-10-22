package com.example.newsfeedapp.features.main_screen.data.api

import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

/* Уровень репозитория ни о каких Flow/ошибках не знает, так как
оперирует самыми простыми моделями */
interface NewsRepository {
    suspend fun getNews(): List<ArticleDomainModel>
}