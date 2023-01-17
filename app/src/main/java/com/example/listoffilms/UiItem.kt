package com.example.listoffilms

sealed class UiItem {
    data class Film(
        val poster: String,
        val name: String,
        val hasOscar: Boolean,
        val rating: Double
    ) : UiItem()

    data class Header(val tittle: String) : UiItem()
}
