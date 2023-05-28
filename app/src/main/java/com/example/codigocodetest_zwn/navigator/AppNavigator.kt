package com.example.codigocodetest_zwn.navigator

import android.os.Bundle

enum class Screens {
    MOVIE_DETAIL
}

interface AppNavigator {
    fun navigateTo(screens: Screens, argus:Bundle? = null)
}