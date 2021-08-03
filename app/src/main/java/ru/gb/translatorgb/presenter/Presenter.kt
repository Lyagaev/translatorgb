package ru.gb.translatorgb.presenter

import ru.gb.translatorgb.model.data.AppState
import ru.gb.translatorgb.view.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
