package com.example.poc.auth.domain

import com.example.poc.core.data.user.User
import com.example.poc.core.data.credentials.CredentialsRepository
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.poc.core.domain.Result

/**
 * Makes the sign in of a new user.
 */
class SignInWithPasswordUseCase(
    private val credentialsRepository: CredentialsRepository,
    private val realmApp: App
) {

    /**
     * Makes the sign in of a new user.
     *
     * @param email
     * @param password
     */
    operator fun invoke(email: String, password: String): Flow<Result<Unit>> = flow {
        emit(Result.Loading())
        try {
            val credentials = credentialsRepository.getCredentials(
                forceRefresh = true,
                email = email,
                password = password
            )
            if (credentials != null) {
                emit(Result.Success(Unit))
            } else {
                emit(Result.Error(InvalidEmailOrPasswordException))
            }

        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    private fun io.realm.kotlin.mongodb.User.toModel() = User(
        realmId = this.id
    )

    object InvalidEmailOrPasswordException : RuntimeException("Invalid email or password.")
}