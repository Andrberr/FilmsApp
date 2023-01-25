package com.example.listoffilms.presenter

import com.example.listoffilms.model.FilmsRepository
import com.example.listoffilms.model.FilmsRepositoryImpl
import com.example.listoffilms.ui.FilmsView

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