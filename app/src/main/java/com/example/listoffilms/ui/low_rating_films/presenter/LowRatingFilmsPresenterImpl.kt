package com.example.listoffilms.ui.low_rating_films.presenter

import com.example.listoffilms.domain.GetLowRatingUseCase
import com.example.listoffilms.ui.low_rating_films.LowRatingFilmsView

class LowRatingFilmsPresenterImpl(private var view: LowRatingFilmsView?): LowRatingFilmsPresenter {

    private val useCase = GetLowRatingUseCase()

    override fun getLowRatingFilms() {
        view?.showLowRatingFilms(useCase())
    }

    override fun onClear() {
       view = null
    }
}