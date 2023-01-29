package com.example.listoffilms.ui.low_rating_films

import com.example.listoffilms.data.models.UiItem

interface LowRatingFilmsView {
    fun showLowRatingFilms(films: List<UiItem>)
}