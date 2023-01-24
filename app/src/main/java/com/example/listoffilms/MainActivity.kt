package com.example.listoffilms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
     @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val films = Server.getFilms()
        val recycler = findViewById<RecyclerView>(R.id.recycler)
         val itemClick: (String, String) -> Unit =  {name, descr ->

             val messageFragment = FilmFragment.newInstance(name, descr)

             supportFragmentManager
                 .beginTransaction()
                 .add(R.id.frame_layout, messageFragment)
                  .addToBackStack("fragment")
                 .commit()
         }
        val adapter = MyAdapter(films, itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }
}