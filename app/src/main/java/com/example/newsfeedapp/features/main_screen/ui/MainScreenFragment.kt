package com.example.newsfeedapp.features.main_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeedapp.R
import com.example.newsfeedapp.features.bokmarks_screen.UIEvent
import com.example.newsfeedapp.features.bokmarks_screen.ViewState
import com.example.newsfeedapp.features.main_screen.ui.adapter.ArticlesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() {
    private val viewModel by viewModel<MainScreenViewModel>()

    private val adapter by lazy {
        ArticlesAdapter(listOf()) {
            viewModel.processUiEvent(UIEvent.OnArticleClick(it))
        }
    }

    override fun onCreateView(
        //LayoutInflater – это класс, который умеет из содержимого layout-файла создать View-элемент. Метод который это делает называется inflate. Есть несколько реализаций этого метода с различными параметрами. Но все они используют друг друга и результат их выполнения один – View.
        //inflate (int resource, ViewGroup root, boolean attachToRoot)
        //на вход метод принимает три параметра:
        //resource - ID layout-файла, который будет использован для создания View. Например - R.layout.main
        //root – родительский ViewGroup-элемент для создаваемого View. LayoutParams от этого ViewGroup присваиваются создаваемому View.
        //attachToRoot – присоединять ли создаваемый View к root. Если true, то root становится родителем создаваемого View.
        // Т.е. это равносильно команде root.addView(View).
        // Если false – то создаваемый View просто получает LayoutParams от root, но его дочерним элементом не становится.
        inflater: LayoutInflater,
        //ViewGroup -это контейнер, который содержит Views
        container: ViewGroup?,
// способ передачи данных между фрагментами: традиционный – с помощью наборов данных Bundle
// способ относительно прост – создаем набор данных «ключ-значение» типа Bundle и передаем через action в первом фрагменте, и извлекаем во втором фрагменте.
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvActicles)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.viewState.observe(viewLifecycleOwner, Observer(::render))


    }

    private fun render(viewState: ViewState) {
        adapter.updateArticles(viewState.articleList)
    }
}