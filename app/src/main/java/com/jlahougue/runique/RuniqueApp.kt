package com.jlahougue.runique

import android.app.Application
import com.jlahougue.auth.data.di.authDataModule
import com.jlahougue.auth.presentation.di.authViewModelModule
import com.jlahougue.core.data.di.coreDataModule
import com.jlahougue.run.presentation.di.runViewModelModule
import com.jlahougue.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                appModule,
                coreDataModule,
                authDataModule,
                authViewModelModule,
                runViewModelModule
            )
        }
    }
}