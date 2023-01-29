package com.example.listoffilms.ui.films

import com.example.listoffilms.data.models.UiItem

interface FilmsView {
    fun showFilms(films: List<UiItem>)
}