package com.jlahougue.auth.presentation.register

import com.jlahougue.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent
    data class Error(val message: UiText) : RegisterEvent
}