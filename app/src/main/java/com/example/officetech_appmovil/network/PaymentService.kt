package com.example.officetech_appmovil.network

import com.example.officetech_appmovil.communication.PaymentResponse
import com.example.officetech_appmovil.models.Payment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface PaymentService {
    @POST("api/v1/payment-details")
    fun createPayment(
        @Header("Authorization") token: String,
        @Body payment: Payment
    ): Call<PaymentResponse>
}