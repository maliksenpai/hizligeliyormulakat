package com.labradorshub.hzlgeliyormlakat.di

import com.labradorshub.hzlgeliyormlakat.ui.detail.DetailViewModel
import com.labradorshub.hzlgeliyormlakat.ui.login.LoginViewModel
import com.labradorshub.hzlgeliyormlakat.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

public val viewmodelmodules = module {
    viewModel { LoginViewModel() }
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel() }
}