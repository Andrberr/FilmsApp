package com.example.listoffilms.ui.low_rating_films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listoffilms.R
import com.example.listoffilms.data.models.UiItem
import com.example.listoffilms.ui.FilmsAdapter
import com.example.listoffilms.ui.HeaderFragment
import com.example.listoffilms.ui.low_rating_films.presenter.LowRatingFilmsPresenter
import com.example.listoffilms.ui.low_rating_films.presenter.LowRatingFilmsPresenterImpl

class LowRatingFilmsActivity : AppCompatActivity(), LowRatingFilmsView {

    private var presenter: LowRatingFilmsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_low_rating_films)
         presenter = LowRatingFilmsPresenterImpl(this)
         presenter?.getLowRatingFilms()
    }

    override fun showLowRatingFilms(films: List<UiItem>) {
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val itemClick: (String, String) -> Unit = { name, descr ->
            val headerFragment = HeaderFragment.newInstance(name, descr)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_layout, headerFragment)
                .addToBackStack("fragment")
                .commit()
        }
        val adapter = FilmsAdapter(films, itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onClear()
    }
}