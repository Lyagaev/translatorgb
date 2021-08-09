package ru.gb.translatorgb.model.datasource

import io.reactivex.Observable
import ru.gb.translatorgb.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    // Добавляем suspend
    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") // To change body of created functions use File
        // | Settings | File Templates.
    }
}