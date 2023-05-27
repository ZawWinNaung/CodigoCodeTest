package com.example.codigocodetest_zwn.utilities

import android.view.View
import androidx.navigation.Navigation
import com.example.codigocodetest_zwn.navigator.AppNavigator
import com.example.codigocodetest_zwn.navigator.AppNavigatorImpl

fun View.provideNavigator(): AppNavigator {
    return AppNavigatorImpl(this)
}

fun View.popBackStack() {
    Navigation.findNavController(this).popBackStack()
}