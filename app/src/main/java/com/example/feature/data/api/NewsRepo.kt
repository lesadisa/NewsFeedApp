package com.example.feature.data.api

import com.example.feature.domain.model.NewsDomainModel

interface NewsRepo {
    fun getNews(): List<NewsDomainModel>
}