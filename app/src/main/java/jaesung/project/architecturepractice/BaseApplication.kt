package jaesung.project.architecturepractice

import android.app.Application
import jaesung.project.architecturepractice.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(networkModule, dataSourceModule, repositoryModule, useCaseModule, viewModelModule)
        }

        setUpTimber()
    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }
}