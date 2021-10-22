package com.example.newsfeedapp.features.main_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeedapp.features.main_screen.ui.adapter.ArticlesAdapter
import com.example.newsfeedapp.R
import com.example.newsfeedapp.features.bokmarks_screen.UIEvent
import com.example.newsfeedapp.features.bokmarks_screen.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment: Fragment() {
    private val viewModel by viewModel<MainScreenViewModel>()
    private val adapter by lazy { ArticlesAdapter(listOf()) {
        viewModel.processUiEvent(UIEvent.OnArticleClick(it))
    } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
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