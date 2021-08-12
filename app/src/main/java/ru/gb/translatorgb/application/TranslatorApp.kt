package ru.gb.translatorgb.application

import android.app.Application
import org.koin.core.context.startKoin
import ru.gb.translatorgb.di.application
import ru.gb.translatorgb.di.mainScreen

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}