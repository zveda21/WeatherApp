package com.example.fragmnttutorialcodes.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmnttutorialcodes.R
import com.example.fragmnttutorialcodes.bases.BaseFragment
import com.example.fragmnttutorialcodes.forecast.ForecastFragment

class SettingsFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
    companion object{
            fun newInstance() = SettingsFragment()

    }
}