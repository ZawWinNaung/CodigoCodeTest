package com.example.codigocodetest_zwn.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.codigocodetest_zwn.R
import com.example.codigocodetest_zwn.databinding.FragmentHomeBinding
import com.example.codigocodetest_zwn.navigator.Screens
import com.example.codigocodetest_zwn.utilities.provideNavigator

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    val viewModel: HomeFragmentViewModel by lazy {
        ViewModelProvider(this)[HomeFragmentViewModel::class.java]
    }

    private fun initViewBinding() {
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        viewModel.popularMovieResponse.observe(this) { response ->
            if (response == null) {
                Toast.makeText(requireContext(), "Fail network call", Toast.LENGTH_LONG).show()
                return@observe
            }
            Log.d("api call ----->", response.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        with(binding) {
            btnNavigate.setOnClickListener {
                it.provideNavigator().navigateTo(Screens.SECOND_SCREEN)
            }
        }
        viewModel.getPopularMovies()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}