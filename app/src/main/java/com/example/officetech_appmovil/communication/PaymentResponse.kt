package com.example.officetech_appmovil.communication

import com.example.officetech_appmovil.models.Payment

data class PaymentResponse (
    val id: Int,
    val cardHolderName: String,
    val cardNumber: String,
    val expiratoryMonth: String,
    val expiratoryYear: String,
    val cvv: String,
    val user_id: Int
) {
    fun toPaymentMethod(): Payment {
        return Payment(
            id = id,
            cardHolderName = cardHolderName,
            cardNumber = cardNumber,
            expiratoryMonth = expiratoryMonth,
            expiratoryYear = expiratoryYear,
            cvv = cvv,
            userId = user_id
        )
    }
}