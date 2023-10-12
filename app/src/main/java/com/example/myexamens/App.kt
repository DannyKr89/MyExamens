package com.example.myexamens

import android.app.Application
import com.example.myexamens.di.homeworksModule
import com.example.myexamens.di.lessonsOfDayModule
import com.example.myexamens.di.timerModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(timerModule, lessonsOfDayModule, homeworksModule))
        }
    }
}