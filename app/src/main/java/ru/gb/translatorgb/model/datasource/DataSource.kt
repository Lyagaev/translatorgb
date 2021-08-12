package ru.gb.translatorgb.model.datasource

import io.reactivex.Observable

// Источник данных для репозитория (Интернет, БД и т. п.)
interface DataSource<T> {
    // Добавляем suspend
    suspend fun getData(word: String): T
}

