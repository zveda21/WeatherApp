package com.example.fragmnttutorialcodes.adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmnttutorialcodes.R
import com.example.fragmnttutorialcodes.models.CurrentLocationWeather

class CurrentDayRecyclerAdapter :RecyclerView.Adapter<CurrentDayRecyclerAdapter.CurrentDayViewHolder>() {



    class CurrentDayViewHolder(recyclerItem:View) : RecyclerView.ViewHolder(recyclerItem){
        var currentDay  = recyclerItem.findViewById<TextView>(R.id.dayTemperature)
        var currentIcon  = recyclerItem.findViewById<ImageView>(R.id.dayWeatherIcon)
        var currentTime  = recyclerItem.findViewById<TextView>(R.id.dayTime)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentDayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_current_day_temperature_item,parent,false)
        return CurrentDayViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrentDayViewHolder, position: Int) {
        holder.currentDay.text = "Today"
        holder.currentTime.text = "16:20"
    }

    override fun getItemCount() = 100

}