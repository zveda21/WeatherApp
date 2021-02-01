package com.example.fragmnttutorialcodes.extensions

import android.annotation.SuppressLint
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

@SuppressLint("ResourceType")
fun AppCompatActivity.addFragment(fragment: Fragment, @LayoutRes layoutResId: Int, tag: String= "TAG") {
      //  tag.let {
//        fragment.tag = tag
      //  }

    val transaction = supportFragmentManager.beginTransaction()
    transaction.add(layoutResId, fragment)
    transaction.commit()
}