package com.kanshamirai.redirectnow.di

import com.kanshamirai.redirectnow.presentation.ui.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel() }
}
