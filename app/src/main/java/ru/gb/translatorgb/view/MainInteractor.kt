package ru.gb.translatorgb.view


import io.reactivex.Observable
import ru.gb.translatorgb.di.NAME_LOCAL
import ru.gb.translatorgb.di.NAME_REMOTE
import ru.gb.translatorgb.model.data.AppState
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.model.repository.Repository
import ru.gb.translatorgb.viewModel.Interactor
import javax.inject.Inject
import javax.inject.Named

class MainInteractor  @Inject constructor(
    // Снабжаем интерактор репозиторием для получения локальных или внешних
    // данных
    @Named(NAME_REMOTE) private val remoteRepository: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {
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