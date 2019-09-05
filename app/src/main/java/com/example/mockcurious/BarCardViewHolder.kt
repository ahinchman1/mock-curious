package com.example.mockcurious

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class BarCardViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.bar_card_viewholder, parent, false)) {

    var barAvi: ImageView? = null
    var barName: TextView? = null
    var barLocation: TextView? = null
    var barDescription: TextView? = null

    init {
        barAvi = itemView.findViewById(R.id.bar_avi)
        barName = itemView.findViewById(R.id.bar_name)
        barLocation = itemView.findViewById(R.id.bar_location)
        barDescription = itemView.findViewById(R.id.bar_description)

    }

    fun bind(avi: String, name: String, location: String, description: String) {
        updateAviView(avi)
        barName?.text = name
        barLocation?.text = location
        barDescription?.text = description
    }

    private fun updateAviView(aviPath: String) {
        if (!aviPath.isNullOrBlank() ) {
            barAvi?.setImageDrawable(null)
        } else {
            barAvi?.load(aviPath)
        }
    }
}