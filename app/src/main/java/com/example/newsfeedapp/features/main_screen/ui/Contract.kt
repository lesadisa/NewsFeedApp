package com.example.newsfeedapp.features.bokmarks_screen

import com.example.newsfeedapp.Base.Event
import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

/* С помощью контракта мы заранее должны спроектировать все действия
пользователя относительно нашего экрана (UIEvent), а также все действия,
которые будут происходить без пользователя (DataEvent) */

data class ViewState(
    val articleList: List<ArticleDomainModel>,
    val errorMessage: String?,
    val isLoading: Boolean
)

sealed class UIEvent() : Event {
    data class OnArticleClick(val articleDomainModel: ArticleDomainModel): UIEvent()
}

sealed class DataEvent() : Event {
    // Симв. о том, что происходит (команда)
    object OnLoadData: DataEvent()
    data class SuccessNewsRequest(val articleList: List<ArticleDomainModel>) : DataEvent()
    data class ErrorNewsRequest(val error: String) : DataEvent()
}