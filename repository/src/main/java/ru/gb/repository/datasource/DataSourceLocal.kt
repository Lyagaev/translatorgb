package ru.gb.repository.datasource

import ru.gb.translatorgb.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
