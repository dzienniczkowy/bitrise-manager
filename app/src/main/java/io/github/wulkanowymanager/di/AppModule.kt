package io.github.wulkanowymanager.di

import io.github.wulkanowymanager.ui.modules.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
}
