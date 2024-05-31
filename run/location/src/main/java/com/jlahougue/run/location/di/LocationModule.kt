package com.jlahougue.run.location.di

import com.jlahougue.run.domain.LocationObserver
import com.jlahougue.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind(LocationObserver::class)
}