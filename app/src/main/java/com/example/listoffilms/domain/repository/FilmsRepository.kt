package com.example.listoffilms.domain.repository

import com.example.listoffilms.data.models.UiItem

interface FilmsRepository {
    fun getFilms(): List<UiItem>
}