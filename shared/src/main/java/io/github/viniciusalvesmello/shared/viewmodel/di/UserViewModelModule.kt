package io.github.viniciusalvesmello.shared.viewmodel.di

import io.github.viniciusalvesmello.shared.viewmodel.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

class UserViewModelModule {
    companion object {
        fun get() = module {
            viewModel { UserViewModel(get()) }
        }
    }
}