package com.jlahougue.run.presentation.active_run

import com.jlahougue.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
    data class Error(val message: UiText) : ActiveRunEvent
    data object RunSaved : ActiveRunEvent
}