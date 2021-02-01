package com.example.fragmnttutorialcodes.extensions

import com.example.fragmnttutorialcodes.bases.BaseActivity
import com.example.fragmnttutorialcodes.bases.BaseFragment

fun BaseFragment.showLoader() {
    (requireActivity() as BaseActivity).showLoader()
}

fun BaseFragment.hideLoader() {
    (requireActivity() as BaseActivity).hideLoader()
}