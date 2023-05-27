package com.example.codigocodetest_zwn.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codigocodetest_zwn.databinding.FragmentSecondBinding
import com.example.codigocodetest_zwn.utilities.popBackStack

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        with(binding) {
            ivBack.setOnClickListener {
                it.popBackStack()
            }
        }
        return binding.root
    }
}