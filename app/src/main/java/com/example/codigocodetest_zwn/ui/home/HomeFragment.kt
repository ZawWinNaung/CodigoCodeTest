package com.example.codigocodetest_zwn.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codigocodetest_zwn.R
import com.example.codigocodetest_zwn.databinding.FragmentHomeBinding
import com.example.codigocodetest_zwn.navigator.Screens
import com.example.codigocodetest_zwn.utilities.provideNavigator
import dagger.hilt.android.AndroidEntryPoint

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel by lazy {
        ViewModelProvider(this)[HomeFragmentViewModel::class.java]
    }

    private lateinit var popularMovieListAdapter: PopularMovieListAdapter
    private lateinit var upcomingMovieListAdapter: UpcomingMovieListAdapter

    private fun initViewBinding() {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        viewModel.popularMovieResponse.observe(this) { response ->
            if (response == null) {
                Toast.makeText(requireContext(), "Fail network call", Toast.LENGTH_LONG).show()
                return@observe
            }
            Log.d("api call ----->", response.results[0].toString())
            popularMovieListAdapter.submitData(response.results)
        }
        viewModel.upcomingMovieResponse.observe(this) { response ->
            if (response == null) {
                Toast.makeText(requireContext(), "Fail network call", Toast.LENGTH_LONG).show()
                return@observe
            }
            upcomingMovieListAdapter.submitData(response.results)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        popularMovieListAdapter = PopularMovieListAdapter()
        upcomingMovieListAdapter = UpcomingMovieListAdapter()
        binding.apply {
            rvPopular.apply {
                adapter = popularMovieListAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
            rvUpcoming.apply {
                adapter = upcomingMovieListAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
        viewModel.getPopularMovies()
        viewModel.getUpcomingMovies()
        return binding.root
    }


}