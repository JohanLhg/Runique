package com.jlahougue.run.presentation.di

import com.jlahougue.run.presentation.active_run.ActiveRunViewModel
import com.jlahougue.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}