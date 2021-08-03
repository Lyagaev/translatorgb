package ru.gb.translatorgb.view

import ru.gb.translatorgb.model.data.AppState


interface View {

    fun renderData(appState: AppState)

}
