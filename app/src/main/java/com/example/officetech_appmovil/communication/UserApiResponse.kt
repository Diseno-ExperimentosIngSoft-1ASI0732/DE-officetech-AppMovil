package com.example.officetech_appmovil.communication

import com.example.officetech_appmovil.models.User

data class UserApiResponse(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val role: String
) {
    fun toUser(): User {
        return User(
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password,
            role = role
        )
    }
}