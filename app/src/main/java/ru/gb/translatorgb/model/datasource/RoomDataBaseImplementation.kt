package ru.gb.translatorgb.model.datasource

import ru.gb.translatorgb.model.data.AppState
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.room.HistoryDao
import ru.gb.translatorgb.utils.convertDataModelSuccessToEntity
import ru.gb.translatorgb.utils.mapHistoryEntityToSearchResult

// Теперь наш локальный репозиторий работает. Передаём в конструктор
// HistoryDao (вспоминаем в модуле Koin RoomDataBaseImplementation(get())).
class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    // Возвращаем список всех слов в виде понятного для Activity
    // List<SearchResult>
    override suspend fun getData(word: String): List<DataModel> {
        // Метод mapHistoryEntityToSearchResult описан во вспомогательном
        // классе SearchResultParser, в котором есть и другие методы для
        // трансформации данных
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    // Метод сохранения слова в БД. Он будет использоваться в интеракторе
    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}


