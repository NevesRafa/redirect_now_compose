package com.kanshamirai.redirectnow.presentation.ui.login.state

data class LoginState (
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String = "",
    val isEmailValid: Boolean = false,
    val isPasswordValid: Boolean = false
)