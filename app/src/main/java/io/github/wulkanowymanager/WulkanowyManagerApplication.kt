package io.github.wulkanowymanager

import android.app.Application
import io.github.wulkanowymanager.data.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WulkanowyManagerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@WulkanowyManagerApplication)
            modules(dataModule, appModule)
        }
    }
}
