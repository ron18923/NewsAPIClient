package com.example.newsapiclient.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsapiclient.domain.usecase.GetSavedNewsUseCase
import com.example.newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.example.newsapiclient.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    val app: Application,
    val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    val saveNewsUseCase: SaveNewsUseCase,
    val getSavedNewsUseCase: GetSavedNewsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase
        ) as T
    }

}