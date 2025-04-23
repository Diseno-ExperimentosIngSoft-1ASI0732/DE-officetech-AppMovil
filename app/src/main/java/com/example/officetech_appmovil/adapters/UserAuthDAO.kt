package com.example.officetech_appmovil.adapters

import androidx.room.Insert
import com.example.officetech_appmovil.models.UserAuth

interface UserAuthDAO {
    @Insert
    fun insertUser(user_auth: UserAuth): Long
}