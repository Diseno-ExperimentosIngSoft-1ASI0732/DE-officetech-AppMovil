package com.example.officetech_appmovil.network

import com.example.officetech_appmovil.communication.AuthResponse
import com.example.officetech_appmovil.models.User
import com.example.officetech_appmovil.models.UserAuth
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    @POST("api/v1/authentication/sign-up")
    fun registerAuthUser(@Body auth: UserAuth): Call<Void>

    // Método para registrar el usuario con el token de autenticación
    @POST("api/v1/auth/register")
    fun registerUserDataWithAuth(
        @Header("Authorization") token: String,
        @Body user: User
    ): Call<User>

    @POST("api/v1/authentication/sign-in")
    fun loginUser(@Body auth: UserAuth): Call<AuthResponse>
}
