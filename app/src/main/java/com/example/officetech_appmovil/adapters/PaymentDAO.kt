package com.example.officetech_appmovil.adapters

import androidx.room.Dao
import androidx.room.Insert
import com.example.officetech_appmovil.models.Payment

@Dao
interface PaymentDAO {
    @Insert
    fun insertPayment(payment: Payment): Long
}