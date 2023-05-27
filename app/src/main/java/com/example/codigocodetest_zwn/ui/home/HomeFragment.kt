package com.example.codigocodetest_zwn.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codigocodetest_zwn.R
import com.example.codigocodetest_zwn.databinding.FragmentHomeBinding
import com.example.codigocodetest_zwn.navigator.Screens
import com.example.codigocodetest_zwn.utilities.provideNavigator

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private fun initViewBinding() {
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
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
        return binding.root
    }
}