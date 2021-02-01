package com.example.fragmnttutorialcodes.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragmnttutorialcodes.forecast.ForecastFragment
import com.example.fragmnttutorialcodes.settings.SettingsFragment
import com.example.fragmnttutorialcodes.weather.WeatherHomeFragment
import java.lang.IllegalStateException

class FragmentPagerAdapter(fragmentActivity: FragmentActivity, private val fragmentsList :MutableList<Fragment>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount():Int = fragmentsList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]

    }
}