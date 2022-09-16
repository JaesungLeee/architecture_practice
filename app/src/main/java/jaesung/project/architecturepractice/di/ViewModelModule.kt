package jaesung.project.architecturepractice.di

import jaesung.project.architecturepractice.presentation.test1.Test1ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { Test1ViewModel(get()) }
}