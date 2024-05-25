package com.jlahougue.auth.data

import com.jlahougue.auth.domain.AuthRepository
import com.jlahougue.core.data.networking.post
import com.jlahougue.core.domain.AuthInfo
import com.jlahougue.core.domain.SessionStorage
import com.jlahougue.core.domain.util.DataError
import com.jlahougue.core.domain.util.EmptyResult
import com.jlahougue.core.domain.util.Result
import com.jlahougue.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(email, password)
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(email, password)
        )
    }
}