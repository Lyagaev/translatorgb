package ru.gb.translatorgb.di


import androidx.room.Room
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.model.datasource.RetrofitImplementation
import ru.gb.translatorgb.model.datasource.RoomDataBaseImplementation
import ru.gb.translatorgb.model.repository.Repository
import ru.gb.translatorgb.model.repository.RepositoryImplementation
import ru.gb.translatorgb.model.repository.RepositoryImplementationLocal
import ru.gb.translatorgb.model.repository.RepositoryLocal
import ru.gb.translatorgb.room.HistoryDataBase
import ru.gb.translatorgb.view.history.HistoryInteractor
import ru.gb.translatorgb.view.history.HistoryViewModel
import ru.gb.translatorgb.view.main.MainInteractor
import ru.gb.translatorgb.view.main.MainViewModel

// Для удобства создадим две переменные: в одной находятся зависимости,
// используемые во всём приложении, во второй - зависимости конкретного экрана
val application = module {
    // single указывает, что БД должна быть в единственном экземпляре
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    // Получаем DAO
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}
// Функция factory сообщает Koin, что эту зависимость нужно создавать каждый
// раз заново, что как раз подходит для Activity и её компонентов.
val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}


