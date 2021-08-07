package ru.gb.translatorgb.application

import android.app.Application
import ru.gb.translatorgb.di.AppComponent
import ru.gb.translatorgb.di.DaggerAppComponent

class TranslatorApp : Application() {

    companion object{
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().build()
    }
}
