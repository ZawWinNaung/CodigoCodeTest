package com.example.codigocodetest_zwn.navigator

import android.os.Bundle

enum class Screens {
    HOME,
    MOVIE_DETAIL
}

interface AppNavigator {
    fun navigateTo(screens: Screens, argus:Bundle? = null)
}