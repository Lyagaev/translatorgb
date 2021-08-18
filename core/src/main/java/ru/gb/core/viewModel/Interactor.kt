package ru.gb.core.viewModel


interface Interactor<T> {
    // Добавляем suspend
    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}