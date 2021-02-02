package com.example.fragmnttutorialcodes.weather

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmnttutorialcodes.ActivityListenerOnWeatherFragment
import com.example.fragmnttutorialcodes.R
import com.example.fragmnttutorialcodes.bases.BaseFragment
import com.example.fragmnttutorialcodes.models.CurrentLocationWeather


class WeatherHomeFragment : BaseFragment(), ActivityListenerOnWeatherFragment {
    private lateinit var currentWeather: CurrentLocationWeather
    private lateinit var currentLocation: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather_home, container, false)
        currentLocation = view.findViewById(R.id.todayWeather)
        //       currentLocation.text = cityName
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        arguments.let {
//            val long = it?.getDouble("Longitude")
//            val lat = it?.getDouble("Latitude")
//            Log.e("Bundle long ", long.toString())
//            Log.e("Bundle lat ", lat.toString())
//        }
    }


    companion object {
        fun newInstance(/*longitude: Double, latitude: Double*/) = WeatherHomeFragment()
//            .apply {
//            arguments.let {
//                it?.putDouble("Longitude", longitude)
//                it?.putDouble("Latitude", latitude)
//            }
//            return this
    }

    //    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        (context as MainActivity).setListenerOnWeatherFragment(this)
//    }
    override fun aboutReceivedCoordinateListener(long: Double, lat: Double) {
        //  currentLocation.text =long.toString()
        Log.e("Interface long ", long.toString())
        Log.e("Interface lat ", lat.toString())
    }
}