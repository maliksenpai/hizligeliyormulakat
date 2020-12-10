package com.labradorshub.hzlgeliyormlakat

import android.app.Application
import com.labradorshub.hzlgeliyormlakat.di.apimodule
import com.labradorshub.hzlgeliyormlakat.di.viewmodelmodules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            this@App
            modules(listOf(viewmodelmodules,apimodule))
            androidContext(applicationContext)
            androidLogger()
        }
    }
}