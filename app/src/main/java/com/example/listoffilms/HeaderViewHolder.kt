package com.example.listoffilms

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(header: UiItem.Header) {
        itemView.findViewById<TextView>(R.id.text).text = header.tittle
    }
}
