package com.example.newsfeedapp.features.main_screen


import androidx.lifecycle.ViewModel
import com.example.feature.Base.BaseViewModel
import com.example.feature.Base.Event
import com.example.feature.domain.NewsInteractor
import com.example.newsfeedapp.features.DataEvent
import com.example.newsfeedapp.features.UIEvent
import com.example.newsfeedapp.features.ViewState

class MainScreenViewModel(private val newsInteractor: NewsInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processUiEvent(UIEvent.GetCurrentNews)
    }

    override fun initialViewState(): ViewState {
        return ViewState(
            articles = listOf(),
            errorMessage = null,
            isLoading = false
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.GetCurrentNews -> {
                processDataEvent(DataEvent.OnDataLoad)
                newsInteractor.getNews().fold(
                    onError = {
                        processDataEvent(DataEvent.ErrorNewsRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessNewsRequest(it))
                    }
                )
            }
            is UIEvent.OnArticleClick -> {
                event.article
                // TODO: Nav
            }
            is DataEvent.OnDataLoad -> {
                return previousState.copy(isLoading = true)
            }
            is DataEvent.SuccessNewsRequest -> {
                return previousState.copy(
                    articles = event.articles,
                    errorMessage = null,
                    isLoading = false
                )
            }
            is DataEvent.ErrorNewsRequest -> {
                return previousState.copy(
                    isLoading = false,
                    errorMessage = event.errorMessage
                )
            }
        }
        return null
    }

}