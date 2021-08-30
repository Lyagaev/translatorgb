package ru.gb.repository.repository

import ru.gb.model.data.dto.SearchResultDto
import ru.gb.repository.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {
    // Репозиторий возвращает данные, используя dataSource (локальный или
    // внешний)
    // Добавляем suspend
    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}


