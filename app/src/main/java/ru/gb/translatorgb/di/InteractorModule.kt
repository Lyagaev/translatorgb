package ru.gb.translatorgb.di

import dagger.Module
import dagger.Provides
import ru.gb.translatorgb.model.data.DataModel
import ru.gb.translatorgb.model.repository.Repository
import ru.gb.translatorgb.view.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
