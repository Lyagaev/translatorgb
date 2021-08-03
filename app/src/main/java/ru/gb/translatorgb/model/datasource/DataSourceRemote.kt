package ru.gb.translatorgb.model.data

import io.reactivex.Observable
import ru.gb.translatorgb.model.datasource.DataSource
import ru.gb.translatorgb.model.datasource.RetrofitImplementation
import ru.gb.translatorgb.model.datasource.RoomDataBaseImplementation

// Для получения внешних данных мы будем использовать Retrofit
class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
// Для локальных данных используется Room
class DataSourceLocal(private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
