package com.example.listoffilms.ui.films

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listoffilms.R
import com.example.listoffilms.data.models.UiItem
import com.example.listoffilms.ui.FilmsAdapter
import com.example.listoffilms.ui.HeaderFragment
import com.example.listoffilms.ui.films.presenter.FilmsPresenter
import com.example.listoffilms.ui.films.presenter.FilmsPresenterImpl
import com.example.listoffilms.ui.low_rating_films.LowRatingFilmsActivity

class MainActivity : AppCompatActivity(), FilmsView {
    private var presenter: FilmsPresenter? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = FilmsPresenterImpl(this)
        presenter?.getFilms()

        val lowRatingButton = findViewById<Button>(R.id.button)
        lowRatingButton.setOnClickListener{
            val intent = Intent(this, LowRatingFilmsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }

    override fun showFilms(films: List<UiItem>) {
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