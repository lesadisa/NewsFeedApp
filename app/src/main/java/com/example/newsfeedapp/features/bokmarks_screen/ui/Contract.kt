package com.example.newsfeedapp.features.bokmarks_screen.ui

import com.example.newsfeedapp.Base.Event
import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

data class ViewState(
    val articleList: List<ArticleDomainModel>
)

sealed class DataEvent: Event {
    object RefreshDataBase: DataEvent()
}