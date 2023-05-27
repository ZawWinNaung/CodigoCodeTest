package com.example.codigocodetest_zwn.navigator

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.Navigation
import com.example.codigocodetest_zwn.R

class AppNavigatorImpl(private val view: View) : AppNavigator {
    override fun navigateTo(screens: Screens, argus: Bundle?) {
        val action = when (screens) {
            Screens.SECOND_SCREEN -> R.id.navigate_to_second_fragment
            else -> R.id.homeFragment
        }
        try {
            Navigation.findNavController(view).navigate(action, argus)
        } catch (e: Exception) {
            Log.d("Unknown Route----->", e.toString())
        }
    }
}