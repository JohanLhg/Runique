package com.jlahougue.auth.domain

import com.jlahougue.core.domain.util.DataError
import com.jlahougue.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}