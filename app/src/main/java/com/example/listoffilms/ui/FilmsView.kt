package com.example.listoffilms.ui

import com.example.listoffilms.model.models.UiItem

interface FilmsView {
    fun showFilms(films: List<UiItem>)
}