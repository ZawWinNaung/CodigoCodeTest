package com.example.codigocodetest_zwn.ui.login

import android.text.TextUtils.isEmpty
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var username = ObservableField("")
    var password = ObservableField("")

    private fun getUsername() = username.get()?.trim().toString()
    private fun getPassword() = password.get()?.trim().toString()

    private var _errorUsername = MutableLiveData<String>()
    val errorUsername: LiveData<String>
        get() = _errorUsername

    private var _errorPassword = MutableLiveData<String>()
    val errorPassword: LiveData<String>
        get() = _errorPassword

    fun validate(): Boolean {
        return if (passValidation()) {
            Log.d("##validation", "true")
            true
        } else {
            if (isEmpty(getUsername())) {
                _errorUsername.value = "User name shouldn't be empty"
            }
            if (isEmpty(getPassword())) {
                _errorPassword.value = "Password shouldn't be empty"
            }
            Log.d("##validation", "false")
            false
        }
    }

    private fun passValidation() = getUsername().isNotEmpty() && getPassword().isNotEmpty()

}