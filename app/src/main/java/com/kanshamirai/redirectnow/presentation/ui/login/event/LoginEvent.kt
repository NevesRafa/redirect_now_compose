package com.kanshamirai.redirectnow.presentation.ui.login.event

sealed class LoginEvent {

     object  OnClickLoginWithGoogle : LoginEvent()
    object  OnClickWithoutLogin : LoginEvent()
    object  OnClickLogin : LoginEvent()
    object  OnClickRegister : LoginEvent()

}