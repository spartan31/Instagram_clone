package com.example.instagram.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagram.model.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    val email = MutableLiveData<String>("krishanyadav31081999@gmail.com")
    val password = MutableLiveData<String>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _authStatus = MutableLiveData<Result<String>>()
    val authStatus: LiveData<Result<String>> get() = _authStatus


    fun login() {
        val emailValue = this.email.value.orEmpty()
        val passwordValue = this.password.value.orEmpty()
        _isLoading.value = true
        viewModelScope.launch {
            authRepository.login(emailValue, passwordValue) { success, message ->
                if (success) {
                    _authStatus.value = Result.success("Login successful")
                    _isLoading.value = false
                } else {
                    _authStatus.value = Result.failure(Exception(message))
                    _isLoading.value = false
                }
            }
        }
    }
}
