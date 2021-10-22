package com.example.feature.data.api

import com.example.feature.domain.model.NewsDomainModel

interface NewsRepo {
    suspend fun getNews(): List<NewsDomainModel>
}