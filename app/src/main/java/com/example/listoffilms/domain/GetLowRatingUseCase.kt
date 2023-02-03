package com.example.listoffilms.domain

import com.example.listoffilms.data.FilmsRepositoryImpl
import com.example.listoffilms.data.models.UiItem
import com.example.listoffilms.domain.repository.FilmsRepository

class GetLowRatingUseCase {
    private val repository: FilmsRepository = FilmsRepositoryImpl()

    operator fun invoke(): List<UiItem> = repository.getFilms().filter {
        when (it) {
            is UiItem.Film -> it.rating < LOW_RATING
            is UiItem.Header -> it.tittle.isEmpty()
        }
    }

    companion object {
        private const val LOW_RATING = 7.0
    }
}