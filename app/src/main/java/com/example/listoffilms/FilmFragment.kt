package com.example.listoffilms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class FilmFragment: Fragment() {
    companion object{
        private val DESCRIPTION = "Description"
        private val NAME = "Name"

        fun newInstance(name: String, description: String): FilmFragment{
            val fragment = FilmFragment()
            val args: Bundle = Bundle()
            args.putString(NAME,name)
            args.putString(DESCRIPTION, description)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.film_descr_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = view.findViewById<TextView>(R.id.name)
        val descr = view.findViewById<TextView>(R.id.description)
        name.text = arguments?.get(NAME) as CharSequence?
        descr.text = arguments?.get(DESCRIPTION) as CharSequence?
    }
}