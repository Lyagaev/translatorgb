package ru.gb.translatorgb.view

import io.reactivex.Observable
import ru.gb.translatorgb.model.data.AppState
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.model.repository.Repository
import ru.gb.translatorgb.presenter.Interactor

class MainInteractor(
    // Снабжаем интерактор репозиторием для получения локальных или внешних
    // данных
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<DataModel> {
    // Интерактор лишь запрашивает у репозитория данные, детали имплементации
    // интерактору неизвестны
    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}