package com.example.newsfeedapp.features.bokmarks_screen.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.newsfeedapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksScreenFragment: Fragment(R.layout.fragment_bookmarks) {
    private val viewModel by viewModel<BookmarksViewModel>()

    companion object {
        fun newInstance() : BookmarksScreenFragment = BookmarksScreenFragment()
    }
    // Иногда переменную нельзя сразу инициализировать, сделать это можно чуть позже.
    // Для таких случаев придумали новый модификатор lateinit (отложенная инициализация).
    // Это относится только к изменяемым переменным.Переменная обязательно должна быть изменяемой (var).
    // Не должна относиться к примитивным типам (Int, Double, Float и т.д). Не должна иметь собственных геттеров/сеттеров.
        private lateinit var bookmarkTitle: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookmarkTitle = view.findViewById<TextView>(R.id.textView)
        viewModel.viewState.observe(viewLifecycleOwner, Observer(::render))
    }

    private fun render(state: ViewState) {
        bookmarkTitle.text = state.articleList.toString()

    }
}