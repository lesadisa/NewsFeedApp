package com.example.newsfeedapp.features.bokmarks_screen.ui

import com.example.newsfeedapp.Base.BaseViewModel
import com.example.newsfeedapp.Base.Event
import com.example.newsfeedapp.features.bokmarks_screen.domain.BookmarkInteractor


class BookmarksViewModel(private val bookmarkInteractor: BookmarkInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.RefreshDataBase)
    }

    override fun initialViewState(): ViewState = ViewState(emptyList())

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when(event) {
            is DataEvent.RefreshDataBase -> {
                val newArticleList = bookmarkInteractor.read()
                return previousState.copy(articleList = newArticleList)
            }
            else -> return null
        }
    }

}