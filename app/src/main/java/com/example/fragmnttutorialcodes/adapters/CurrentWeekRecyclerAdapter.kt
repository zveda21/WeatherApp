package com.example.fragmnttutorialcodes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmnttutorialcodes.R

class CurrentWeekRecyclerAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    class CurrentWeekViewHolder(weekItem: View) : BaseViewHolder(weekItem) {
        val weekDay = weekItem.findViewById<TextView>(R.id.weekDay)
        val imageWeather = weekItem.findViewById<ImageView>(R.id.imageWeather)
        val weatherType = weekItem.findViewById<TextView>(R.id.weatherType)
        val temperatureDayTime = weekItem.findViewById<TextView>(R.id.temperatureDayTime)
        val temperatureNight = weekItem.findViewById<TextView>(R.id.temperatureNight)

        override fun bind() {
            weekDay.text = "Today"
            imageWeather.setImageResource(R.drawable.sun_cheked)
            weatherType.text = "Sunny"
            temperatureDayTime.text = "25C"
            temperatureNight.text = "17C"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val currentWeekView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_current_week_temperature_item, parent, false)
        return CurrentWeekViewHolder(currentWeekView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = 7
}