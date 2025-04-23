package com.example.officetech_appmovil.adapters

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.officetech_appmovil.models.User
import com.example.officetech_appmovil.models.UserAuth


@Dao
interface UserDAO {
    @Insert
    fun insertUser(user: User): Long

}