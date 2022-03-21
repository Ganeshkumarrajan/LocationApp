package com.nordsec.locationapp

import android.app.Application
import android.content.Context
import com.nordsec.locationapp.di.DataResourceModule
import com.nordsec.locationapp.di.repositoryModule
import com.nordsec.locationapp.di.useCaseModule
import com.nordsec.locationapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        startKoin {
            androidContext(this@App)
            modules(
                DataResourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }

    companion object {
        private var currentApplication: Application? = null
        private val application: Application?
            get() = currentApplication
        val context: Context
            get() = application!!.applicationContext
    }
}