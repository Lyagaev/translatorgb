package ru.gb.translatorgb.di


import androidx.room.Room
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.repository.datasource.RetrofitImplementation
import ru.gb.repository.datasource.RoomDataBaseImplementation
import ru.gb.repository.repository.Repository
import ru.gb.repository.repository.RepositoryImplementation
import ru.gb.repository.repository.RepositoryImplementationLocal
import ru.gb.repository.repository.RepositoryLocal
import ru.gb.repository.room.HistoryDataBase
import ru.gb.translatorgb.view.main.MainInteractor
import ru.gb.translatorgb.view.main.MainViewModel

/*// Для удобства создадим две переменные: в одной находятся зависимости,
// используемые во всём приложении, во второй - зависимости конкретного экрана
val application = module {
    // single указывает, что БД должна быть в единственном экземпляре
    single { Room.databaseBuilder(get(), ru.gb.repository.room.HistoryDataBase::class.java, "HistoryDB").build() }
    // Получаем DAO
    single { get<ru.gb.repository.room.HistoryDataBase>().historyDao() }
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
}*/


// Объявим функцию, которая будет создавать зависимости по требованию
fun injectDependencies() = loadModules
// Ленивая инициализация создаст зависимости только тогда, когда функция будет
// вызвана
private val loadModules by lazy {
    // Функция библиотеки Koin
    loadKoinModules(listOf(application, mainScreen))
}
// Остальное никак не изменилось
val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

