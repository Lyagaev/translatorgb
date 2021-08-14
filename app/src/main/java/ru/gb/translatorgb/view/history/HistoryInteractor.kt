package ru.gb.translatorgb.view.history

import ru.gb.translatorgb.model.data.AppState
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.model.repository.Repository
import ru.gb.translatorgb.model.repository.RepositoryLocal
import ru.gb.translatorgb.viewModel.Interactor


// Класс мало чем отличается от интерактора, который мы уже описывали
class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState{
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
