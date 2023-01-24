package com.example.listoffilms.model.models

sealed class UiItem {
    data class Film(
        val poster: String,
        val name: String,
        val hasOscar: Boolean,
        val rating: Double,
        val description: String
    ) : UiItem()

    data class Header(val tittle: String) : UiItem()
}
