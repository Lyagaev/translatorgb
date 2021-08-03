package ru.gb.translatorgb.model.repository

import io.reactivex.Observable
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    // Репозиторий возвращает данные, используя dataSource (локальный или
    // внешний)
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
