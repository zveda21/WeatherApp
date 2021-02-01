package com.example.fragmnttutorialcodes.bases

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract fun hideLoader()
    abstract fun showLoader()
}