package com.example.mockcurious

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mockcurious.models.Bar

class BarCardAdapter(private var bars: List<Bar>): RecyclerView.Adapter<BarCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarCardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BarCardViewHolder(layoutInflater, parent)
    }

    override fun getItemCount(): Int = bars.size

    fun setBars(bars: List<Bar>) {
        this.bars = bars
    }

    override fun onBindViewHolder(holder: BarCardViewHolder, position: Int) {
        val bar: Bar = bars[position]
        holder.bind(bar.image, bar.name, bar.address, bar.description)
    }

}