package com.example.fragmnttutorialcodes.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmnttutorialcodes.R
import com.example.fragmnttutorialcodes.adapters.CurrentDayRecyclerAdapter
import com.example.fragmnttutorialcodes.adapters.CurrentWeekRecyclerAdapter
import com.example.fragmnttutorialcodes.bases.BaseFragment
import com.example.fragmnttutorialcodes.databinding.FragmentForecastBinding
import com.example.fragmnttutorialcodes.models.CurrentLocationWeather
import com.example.fragmnttutorialcodes.models.Sys


class ForecastFragment : BaseFragment() {
    private lateinit var bindingForecast: FragmentForecastBinding
    private lateinit var recyclerOfDay: RecyclerView
    private lateinit var recyclerOfWeek: RecyclerView
    private lateinit var adapterCurrentDayRec: CurrentDayRecyclerAdapter
    private lateinit var adapterCurrentDWeekRec: CurrentWeekRecyclerAdapter
    private lateinit var currentWeather : CurrentLocationWeather

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //  val view = inflater.inflate(R.layout.fragment_forecast, container, false)
        bindingForecast = FragmentForecastBinding.inflate(inflater, container, false)
        findView()
        initCurrentDayRecycler(recyclerOfDay)
        initCurrentWeekRecycler(recyclerOfWeek)


        return bindingForecast.root
    }

    private fun findView() {
        recyclerOfDay = bindingForecast.root.findViewById(R.id.currentDayTemperature)
        recyclerOfWeek = bindingForecast.root.findViewById(R.id.currentWeekTemperature)
    }

    private fun initCurrentDayRecycler(recycler: RecyclerView) {
        adapterCurrentDayRec = CurrentDayRecyclerAdapter()
        recycler.apply {
            val lay = LinearLayoutManager(requireActivity())
            lay.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager = lay
            adapter = this@ForecastFragment.adapterCurrentDayRec
        }
    }

    private fun initCurrentWeekRecycler(recycler: RecyclerView) {
        adapterCurrentDWeekRec = CurrentWeekRecyclerAdapter()
        recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = this@ForecastFragment.adapterCurrentDWeekRec
        }

    }

    companion object {
        fun newInstance() = ForecastFragment()
    }

}