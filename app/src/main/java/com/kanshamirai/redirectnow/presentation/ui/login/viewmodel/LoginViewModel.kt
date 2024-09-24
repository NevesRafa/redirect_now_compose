package com.kanshamirai.redirectnow.presentation.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanshamirai.redirectnow.presentation.ui.login.event.LoginEvent
import com.kanshamirai.redirectnow.presentation.ui.login.state.LoginState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    private val pendingActions = MutableSharedFlow<LoginEvent>()

    init {
        handleEvent()
    }

    fun onEvent(event: LoginEvent) {
        viewModelScope.launch {
            pendingActions.emit(event)
        }
    }

    private fun handleEvent() {
        viewModelScope.launch {
            pendingActions.collect { event ->
                when (event) {
                    is LoginEvent.OnClickLoginWithGoogle -> {
                        // Handle Google login
                    }

                    is LoginEvent.OnClickWithoutLogin -> {
                        // Handle without login
                    }

                    is LoginEvent.OnClickLogin -> {
                        // Handle login
                    }

                    is LoginEvent.OnClickRegister -> {
                        // Handle register
                    }
                }
            }
        }
    }
}