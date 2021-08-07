package ru.gb.translatorgb.view

import androidx.appcompat.app.AppCompatActivity
import ru.gb.translatorgb.model.data.AppState
import ru.gb.translatorgb.viewModel.Interactor
import ru.gb.translatorgb.viewModel.BaseViewModel

abstract class BaseActivity<T : AppState, I : Interactor<T>> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(dataModel: T)
}