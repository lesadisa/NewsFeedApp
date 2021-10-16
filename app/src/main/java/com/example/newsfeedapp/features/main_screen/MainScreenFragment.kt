package com.example.newsfeedapp.features.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsfeedapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() { //()-инициализация
    private val viewModel by viewModel<MainScreenViewModel>()

    override fun onCreateView( //для фрагмента Inflater
        inflater: LayoutInflater, //создаем переменную Inflater
        container: ViewGroup?, // переменная для ViewGroup
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_mainscreen,
            container,
            false
        ) //если true то унаследует от основной
    }
}