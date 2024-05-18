package com.jlahougue.auth.data

import com.jlahougue.auth.domain.AuthRepository
import com.jlahougue.core.data.networking.post
import com.jlahougue.core.domain.util.DataError
import com.jlahougue.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(email, password)
        )
    }
}