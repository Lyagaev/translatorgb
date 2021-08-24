package ru.gb.historyscreen.history

import ru.gb.model.data.AppState
import ru.gb.model.data.dto.SearchResultDto
import ru.gb.core.viewModel.Interactor
import ru.gb.repository.repository.Repository
import ru.gb.repository.repository.RepositoryLocal
import ru.gb.translatorgb.utils.mapSearchResultToResult


// Класс мало чем отличается от интерактора, который мы уже описывали
class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
