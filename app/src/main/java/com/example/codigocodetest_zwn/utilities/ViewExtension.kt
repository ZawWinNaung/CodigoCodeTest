package com.example.codigocodetest_zwn.utilities

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.codigocodetest_zwn.navigator.AppNavigator
import com.example.codigocodetest_zwn.navigator.AppNavigatorImpl
import com.example.codigocodetest_zwn.utilities.Constants.Companion.POSTER_BASE_URL
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

fun View.provideNavigator(): AppNavigator {
    return AppNavigatorImpl(this)
}

fun View.popBackStack() {
    Navigation.findNavController(this).popBackStack()
}

fun ImageView.setGlide(imageUrl: String) {
    Glide.with(this.context).load(POSTER_BASE_URL + imageUrl).centerCrop().into(this)
}