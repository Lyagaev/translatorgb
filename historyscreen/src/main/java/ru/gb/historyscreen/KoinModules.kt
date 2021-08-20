package ru.gb.historyscreen

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import ru.gb.historyscreen.history.HistoryViewModel
import ru.gb.translatorgb.view.history.HistoryInteractor

fun injectDependencies() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(listOf(historyScreen))
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
