package com.jlahougue.auth.presentation.login

import com.jlahougue.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val message: UiText) : LoginEvent
    data object LoginSuccess : LoginEvent
}