package com.example.poc.core.data.credentials

interface CredentialsRemoteDataSource {

    /**
     * Retrieves an user from the RockSpoon merchant web service
     * @param request GetCredentialsRequest.Email or GetCredentialsRequest.PinCode
     */
    suspend fun getCredentials(request: GetCredentialsRequest): Credentials?


    /**
     * Retrieves an user from the RockSpoon merchant web service
     */
    suspend fun getCredentials(email: String, password: String): Credentials?

    /**
     * Retrieves credentials for user by pinCode and venue api_key from the RockSpoon merchant web service
     */
    suspend fun getCredentialsByPinCode(
        pinCode: String,
        key: String,
        deviceId: String
    ): Credentials?

    /**
     * Uses the refresh token to get new credentials tokens
     */
    suspend fun updateCredentials(refreshToken: String): Credentials

    object InvalidRefreshTokenException : RuntimeException("Invalid refresh token.")

    object InvalidEmailOrPasswordException : RuntimeException("Invalid email or password.")

}