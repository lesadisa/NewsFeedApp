package com.example.newsfeedapp.features.main_screen.ui

import com.example.newsfeedapp.Base.BaseViewModel
import com.example.newsfeedapp.Base.Event
import com.example.newsfeedapp.features.main_screen.domain.NewsInteractor
import com.example.newsfeedapp.features.bokmarks_screen.DataEvent
import com.example.newsfeedapp.features.bokmarks_screen.UIEvent
import com.example.newsfeedapp.features.bokmarks_screen.ViewState
import com.example.newsfeedapp.features.bokmarks_screen.domain.BookmarkInteractor


class MainScreenViewModel(
    private val newsInteractor: NewsInteractor,
    private val bookmarkInteractor: BookmarkInteractor
) : BaseViewModel<ViewState>() {
    init {
        processDataEvent(DataEvent.OnLoadData)
    }

    override fun initialViewState(): ViewState {
        return ViewState(emptyList(), null, true)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnArticleClick -> {
                bookmarkInteractor.create(event.articleDomainModel)
            }
            is DataEvent.OnLoadData -> {
                newsInteractor.getNews().fold(
                    onSuccess = { processDataEvent(DataEvent.SuccessNewsRequest(it)) },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorNewsRequest(
                                it.localizedMessage ?: ""
                            )
                        )
                    }
                )
            }
            is DataEvent.SuccessNewsRequest -> {
                return previousState.copy(articleList = event.articleList, isLoading = false)
            }
            is DataEvent.ErrorNewsRequest -> {
            }
        }
        return null
    }
}