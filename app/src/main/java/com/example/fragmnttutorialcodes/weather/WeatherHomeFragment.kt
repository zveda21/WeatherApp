package com.example.fragmnttutorialcodes.weather

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.fragmnttutorialcodes.R
import com.example.fragmnttutorialcodes.bases.BaseFragment
import com.example.fragmnttutorialcodes.models.CurrentLocationWeather
import java.util.*

class WeatherHomeFragment : BaseFragment() {
    private lateinit  var currentWeather : CurrentLocationWeather
    private lateinit var currentLocation :TextView
    private  lateinit var locationManager: LocationManager
    private lateinit var toolBar : Toolbar
    private lateinit var  cityName : String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_weather_home, container, false)

//        val cityName = this.arguments?.getString("CityName")
//        if (cityName != null) {
//            Log.e("Bundle CityName ", cityName)
//        }

        currentLocation = view.findViewById(R.id.todayWeather)
 //       currentLocation.text = cityName
        return view
    }


    companion object{
        fun newInstance() = WeatherHomeFragment()
    }
}