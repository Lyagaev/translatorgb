package ru.gb.translatorgb.model.repository

import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    // Репозиторий возвращает данные, используя dataSource (локальный или
    // внешний)
    // Добавляем suspend
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}


