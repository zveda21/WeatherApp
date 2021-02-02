package com.example.fragmnttutorialcodes

import android.Manifest
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.*
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmnttutorialcodes.adapters.FragmentPagerAdapter
import com.example.fragmnttutorialcodes.bases.BaseActivity
import com.example.fragmnttutorialcodes.databinding.ActivityMainBinding
import com.example.fragmnttutorialcodes.forecast.ForecastFragment
import com.example.fragmnttutorialcodes.settings.SettingsFragment
import com.example.fragmnttutorialcodes.weather.WeatherHomeFragment
import com.google.android.material.navigation.NavigationView
import java.util.*
import kotlin.properties.Delegates


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var locationManager: LocationManager
    private var long by Delegates.notNull<Double>()
    private var lat by Delegates.notNull<Double>()
    private lateinit var listOfFragments: MutableList<Fragment>
    private lateinit var activityListenerOnWeatherFragment: ActivityListenerOnWeatherFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        if (checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )
        }

        initView()
        getCurrentLocation()
        setUpPagerAdapter()
        navigationItemSelected()
        Toast.makeText(this, long.toString(), Toast.LENGTH_LONG).show()
//        val bundle = Bundle()
//        bundle.putDouble("Longitude",long)
//        bundle.putDouble("Latitude",lat)
//        val weatherHomeFragment =  WeatherHomeFragment.newInstance()
//        weatherHomeFragment.arguments = bundle


    }


    fun setListenerOnWeatherFragment(activityListenerOnWeatherFragment: ActivityListenerOnWeatherFragment) {
        this.activityListenerOnWeatherFragment = activityListenerOnWeatherFragment
        activityListenerOnWeatherFragment.aboutReceivedCoordinateListener(long, lat)

    }

    private fun initView() {
        mainBinding.navDrawer.setNavigationItemSelectedListener(this)
        val drawerToggle = ActionBarDrawerToggle(
            this,
            mainBinding.drawerLayout, mainBinding.fragmentsToolbar,
            R.string.open,
            R.string.close
        )
        drawerToggle.drawerArrowDrawable = DrawerArrowDrawable(this)
        setSupportActionBar(mainBinding.fragmentsToolbar)


    }

    private fun setUpPagerAdapter() {
        listOfFragments = mutableListOf(
            WeatherHomeFragment.newInstance(/*long,lat*/),
            ForecastFragment.newInstance(), SettingsFragment.newInstance()
        )
        val pagerAdapter = FragmentPagerAdapter(this, listOfFragments)
        mainBinding.fragmentPager.adapter = pagerAdapter
        val pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        mainBinding.bottomNavigation.menu.findItem(R.id.weather).isChecked = true
                    }
                    1 -> {
                        mainBinding.bottomNavigation.menu.findItem(R.id.forecast).isChecked = true
                    }
                    2 -> {
                        mainBinding.bottomNavigation.menu.findItem(R.id.settings).isChecked = true
                    }
                }

            }
        }
        mainBinding.fragmentPager.registerOnPageChangeCallback(pageChangeListener)
    }

    private fun navigationItemSelected() {
        mainBinding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.weather -> {
                    mainBinding.fragmentPager.currentItem = 0
                }
                R.id.forecast -> {
                    mainBinding.fragmentPager.currentItem = 1
                }
                R.id.settings -> {
                    mainBinding.fragmentPager.currentItem = 2
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

    }


    override fun hideLoader() {
        TODO("Not yet implemented")
    }

    override fun showLoader() {
        TODO("Not yet implemented")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.inbox -> {
                Toast.makeText(this, "inbox", Toast.LENGTH_SHORT).show()
            }
            R.id.sentMail -> {
                Toast.makeText(this, "sentMail", Toast.LENGTH_SHORT).show()
            }
            R.id.rate -> {
                Toast.makeText(this, "rate", Toast.LENGTH_SHORT).show()
            }
            R.id.privacy -> {
                Toast.makeText(this, "privacy", Toast.LENGTH_SHORT).show()
            }
            R.id.faq -> {
                Toast.makeText(this, "faq", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                mainBinding.drawerLayout.openDrawer(GravityCompat.START);  // OPEN DRAWER
                Log.d("NICK", "CWECNEWKVNERIPNVIEWNFVIPEWNVIPEWNVPIEWNVPIEWNVPIEWNVPIRWNVPRWVPO")
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }

    private fun getCurrentLocation() {
        try {
            locationManager =
                applicationContext.getSystemService(LOCATION_SERVICE) as LocationManager
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
                != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            Log.e("Location", location.toString())
            if (location != null) {
                long = location.longitude
                lat = location.latitude
            }

            Log.e("Long ===lat ", "$long ////$lat")

            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5L, 5F, this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

//    override fun onLocationChanged(location: Location) {
//        Log.e("My log and lat ", location.latitude.toString() + " " + location.longitude.toString())
//        try {
//            val myGeocoder = Geocoder(this@MainActivity, Locale.getDefault())
//            val addresses = myGeocoder.getFromLocation(location.latitude, location.longitude, 1)
//            val address = addresses[0].getAddressLine(0)
//            cityName = addresses[0].locality
//
//            mainBinding.fragmentsToolbar.title = cityName
//
//            Log.e("My Address", address)
//            Log.e("My cityName", cityName)
//            // Toast.makeText(this, "City $cityName",Toast.LENGTH_LONG).show()
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }


}


interface ActivityListenerOnWeatherFragment {
    fun aboutReceivedCoordinateListener(long: Double, lat: Double)
}