package com.example.feature.Base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<VIEW_STATE> : ViewModel() {

    val viewState: MutableLiveData<VIEW_STATE> by lazy { MutableLiveData(initialViewState()) }

    abstract fun initialViewState(): VIEW_STATE
    // берет два возвращает новое состояние
    abstract suspend fun reduce(event: Event, previousState: VIEW_STATE): VIEW_STATE?

    fun processUiEvent(event: Event) { // событие нажатие
        updateState(event)
    }

    protected fun processDataEvent(event: Event) { //вычисления
        updateState(event)
    }
    //создает новое ViewState
    private fun updateState(event: Event) = viewModelScope.launch {
        val newViewState = reduce(event, viewState.value ?: initialViewState())
        if (newViewState != null && newViewState != viewState.value) {
            viewState.value = newViewState
        }
    }
}