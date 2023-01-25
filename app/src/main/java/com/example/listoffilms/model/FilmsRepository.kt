package com.example.listoffilms.model

import com.example.listoffilms.model.models.UiItem

interface FilmsRepository {
    fun getFilms(): List<UiItem>
}