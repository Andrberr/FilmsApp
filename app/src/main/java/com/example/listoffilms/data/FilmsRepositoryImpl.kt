package com.example.listoffilms.data

import com.example.listoffilms.Server
import com.example.listoffilms.data.models.UiItem
import com.example.listoffilms.domain.repository.FilmsRepository

class FilmsRepositoryImpl : FilmsRepository {

  override fun getFilms(): List<UiItem> = Server.getFilms()
}