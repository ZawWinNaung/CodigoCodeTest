package com.example.codigocodetest_zwn.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codigocodetest_zwn.data.SharedRepository
import com.example.codigocodetest_zwn.model.PopularMovieResponse
import com.example.codigocodetest_zwn.model.UpcomingMovieResponse
import com.example.codigocodetest_zwn.utilities.Constants.Companion.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val repository: SharedRepository) :
    ViewModel() {

    private val _popularMovies = MutableLiveData<PopularMovieResponse?>()

    val popularMovieResponse: LiveData<PopularMovieResponse?>
        get() = _popularMovies

    private val _upcomingMovies = MutableLiveData<UpcomingMovieResponse?>()
    val upcomingMovieResponse: LiveData<UpcomingMovieResponse?>
        get() = _upcomingMovies

    fun getPopularMovies() {
        viewModelScope.launch {
            val response = repository.getPopularMovies(API_KEY)
            _popularMovies.postValue(response)
        }
    }

    fun getUpcomingMovies() {
        viewModelScope.launch {
            val response = repository.getUpcomingMovies(API_KEY)
            _upcomingMovies.postValue(response)
        }
    }
}