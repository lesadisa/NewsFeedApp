package com.example.newsfeedapp.Base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<VIEW_STATE> : ViewModel() {

    val viewState: MutableLiveData<VIEW_STATE> by lazy { MutableLiveData(initialViewState()) }

    abstract fun initialViewState(): VIEW_STATE

    /* Пример - польз. переключил слайдер -> придет событие об этом (слайдер = 1) ->
    записываем это в предыдущее состояние -> получаем новое, которое вернется на экран
    Происходит это с помощью метода data-класса - copy
     */
    abstract suspend fun reduce(event: Event, previousState: VIEW_STATE): VIEW_STATE?

    //    Событие, которое было сделано пользователем (нажатие на кнопку)
    fun processUiEvent(event: Event) {
        updateState(event)
    }

    //    Запускает цепочки вычислений без участия пользователя
    protected fun processDataEvent(event: Event) {
        updateState(event)
    }

    private fun updateState(event: Event) = viewModelScope.launch {
        val newViewState = reduce(event, viewState.value ?: initialViewState())
        if (newViewState != null && newViewState != viewState.value) {
            viewState.value = newViewState
        }
    }
}