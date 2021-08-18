package ru.gb.translatorgb.view.main


import ru.gb.translatorgb.model.data.AppState
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.repository.repository.Repository
import ru.gb.repository.repository.RepositoryLocal
import ru.gb.core.viewModel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {
    // Добавляем suspend
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        // Теперь полученное слово мы сохраняем в БД. Сделать это нужно именно
        // здесь, в соответствии с принципами чистой архитектуры: интерактор
        // обращается к репозиторию
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}

