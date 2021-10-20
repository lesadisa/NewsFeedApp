package com.example.newsfeedapp.features.main_screen

import com.example.feature.Base.BaseViewModel
import com.example.feature.Base.Event
import com.example.feature.domain.NewsInteractor
import com.example.newsfeedapp.features.DataEvent
import com.example.newsfeedapp.features.UIEvent
import com.example.newsfeedapp.features.ViewState

class MainScreenViewModel(private val interactor: NewsInteractor) : BaseViewModel<ViewState>() {
    init {
        processDataEvent(DataEvent.OnloadData)
    }

    override fun initialViewState(): ViewState {
        return ViewState(articleList = listOf(), errorMesage = null, isloading = true)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.OnloadData -> {
                interactor.getNews().fold(
                    onSuccess = {
                        processDataEvent(DataEvent.SuccesNewsRequest(articleList = it))
                    },
                    onError = {

                    }
                )
            }
            is UIEvent.OnArticleClick -> {

            }
            is DataEvent.SuccesNewsRequest -> {
                return previousState.copy(articleList = event.articleList, isloading = false)
            }

        }
        return null
    }
}