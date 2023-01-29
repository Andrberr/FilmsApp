package com.example.listoffilms.ui.films.presenter

import com.example.listoffilms.domain.repository.FilmsRepository
import com.example.listoffilms.data.FilmsRepositoryImpl
import com.example.listoffilms.ui.films.FilmsView

class FilmsPresenterImpl(private var view: FilmsView?) : FilmsPresenter {
    private val repository: FilmsRepository = FilmsRepositoryImpl()
    override fun getFilms() {
        val films = repository.getFilms()
        view?.showFilms(films)
    }

    override fun onClear() {
        view = null
    }
}