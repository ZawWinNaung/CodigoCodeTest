package com.example.codigocodetest_zwn.navigator

import android.os.Bundle

enum class Screens {
    SECOND_SCREEN
}

interface AppNavigator {
    fun navigateTo(screens: Screens, argus:Bundle? = null)
}