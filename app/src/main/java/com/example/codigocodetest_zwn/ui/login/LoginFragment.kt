package com.example.codigocodetest_zwn.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.codigocodetest_zwn.databinding.FragmentLoginBinding
import com.example.codigocodetest_zwn.navigator.Screens
import com.example.codigocodetest_zwn.utilities.provideNavigator

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    private fun initViewBinding() {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        loginViewModel.errorUsername.observe(this) {
            binding.tlUsername.error = it
        }
        loginViewModel.errorPassword.observe(this) {
            binding.tlPassword.error = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            btnLogin.setOnClickListener {
                if (loginViewModel.validate()) {
                    Log.d("##validation", loginViewModel.validate().toString())
                    it.provideNavigator().navigateTo(Screens.HOME)
                }
            }
            etUsername.addTextChangedListener {
                tlUsername.error = null
            }
            etPassword.addTextChangedListener {
                tlPassword.error = null
            }
        }
        return binding.root
    }
}