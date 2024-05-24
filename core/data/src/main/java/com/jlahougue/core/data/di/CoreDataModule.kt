package com.jlahougue.core.data.di

import com.jlahougue.core.data.auth.EncryptedSessionStorage
import com.jlahougue.core.data.networking.HttpClientFactory
import com.jlahougue.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}