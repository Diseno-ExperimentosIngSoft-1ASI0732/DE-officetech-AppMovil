package com.example.officetech_appmovil.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "suscriptionpayment")
data class Payment (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "card_holder_name")
    val cardHolderName: String,

    @ColumnInfo(name = "card_number")
    val cardNumber: String,

    @ColumnInfo(name = "expiratory_month")
    val expiratoryMonth: String,

    @ColumnInfo(name = "expiratory_year")
    val expiratoryYear: String,

    @ColumnInfo(name = "cvv")
    val cvv: String,

    @SerializedName("user_id")
    @ColumnInfo(name = "user_id")
    val userId: Int
)