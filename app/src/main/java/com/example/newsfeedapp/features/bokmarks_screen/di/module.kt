package com.example.newsfeedapp.features.bokmarks_screen.di

import com.example.newsfeedapp.features.bokmarks_screen.data.BookmarksRepo
import com.example.newsfeedapp.features.bokmarks_screen.data.BookmarksRepoImpl
import com.example.newsfeedapp.features.bokmarks_screen.data.local.BookmarkDAO
import com.example.newsfeedapp.features.bokmarks_screen.domain.BookmarkInteractor
import com.example.newsfeedapp.features.bokmarks_screen.ui.BookmarksViewModel
import org.koin.android.compat.ViewModelCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bookmarksModule = module {
    single<BookmarksRepo> {
        BookmarksRepoImpl(get<BookmarkDAO>())
    }

    single<BookmarkInteractor> {
        BookmarkInteractor(get<BookmarksRepo>())
    }

    viewModel<BookmarksViewModel> {
        BookmarksViewModel(get<BookmarkInteractor>())
    }
}