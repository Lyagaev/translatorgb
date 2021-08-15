package ru.gb.translatorgb.model.repository

import ru.gb.translatorgb.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
