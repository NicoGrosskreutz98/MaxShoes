package com.grosskreutz.maxshoes

import android.app.Application
import android.os.Bundle
import com.grosskreutz.maxshoes.modulo.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : Application() {

    private var koinInicializada = false
    override fun onCreate() {
        super.onCreate()

        if (!koinInicializada)
            startKoin {
                androidContext(this@MainActivity)
                modules(appModule)
                koinInicializada = true
            }
    }
}