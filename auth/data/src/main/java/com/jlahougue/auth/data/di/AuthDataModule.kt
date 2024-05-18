package com.jlahougue.auth.data.di

import com.jlahougue.auth.data.AuthRepositoryImpl
import com.jlahougue.auth.data.EmailPatternValidator
import com.jlahougue.auth.domain.AuthRepository
import com.jlahougue.auth.domain.PatternValidator
import com.jlahougue.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}