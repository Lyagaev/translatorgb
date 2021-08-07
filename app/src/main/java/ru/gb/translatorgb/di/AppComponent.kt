package ru.gb.translatorgb.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.gb.translatorgb.application.TranslatorApp
import ru.gb.translatorgb.view.MainActivity
import javax.inject.Singleton

// Тут мы прописываем все наши модули, включая AndroidSupportInjectionModule.
// Этот класс создаётся Dagger’ом. Он как раз связан с аннотацией ContributesAndroidInjector выше и позволяет внедрять в Activity все
// необходимые зависимости
@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        ViewModelModule::class]
)
@Singleton
interface AppComponent {
    // Этот билдер мы вызовем из класса TranslatorApp, который наследует
    // Application
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun endPoint(endpoint: String): Builder

        fun build(): AppComponent
    }

    // Наш кастомный Application
    fun inject(englishVocabularyApp: TranslatorApp)
    fun inject(activity: MainActivity)
}
