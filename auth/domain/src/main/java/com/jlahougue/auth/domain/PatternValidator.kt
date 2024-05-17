package com.jlahougue.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}