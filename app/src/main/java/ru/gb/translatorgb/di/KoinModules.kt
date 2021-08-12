package ru.gb.translatorgb.di


import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.model.datasource.RetrofitImplementation
import ru.gb.translatorgb.model.datasource.RoomDataBaseImplementation
import ru.gb.translatorgb.model.repository.Repository
import ru.gb.translatorgb.model.repository.RepositoryImplementation
import ru.gb.translatorgb.view.MainInteractor
import ru.gb.translatorgb.view.MainViewModel

// Для удобства создадим две переменные: в одной находятся зависимости,
// используемые во всём приложении, во второй - зависимости конкретного экрана
val application = module {
    // Функция single сообщает Koin, что эта зависимость должна храниться
    // в виде синглтона (в Dagger есть похожая аннотация)
    // Аннотация named выполняет аналогичную Dagger функцию
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation()
    ) }
}
// Функция factory сообщает Koin, что эту зависимость нужно создавать каждый
// раз заново, что как раз подходит для Activity и её компонентов.
val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}

