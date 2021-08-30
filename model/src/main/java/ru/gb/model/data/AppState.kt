package ru.gb.model.data

import ru.gb.model.data.userdata.DataModel

sealed class AppState{

    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}

