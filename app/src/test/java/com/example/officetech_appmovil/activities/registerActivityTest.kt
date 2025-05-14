package com.example.officetech_appmovil.activities



import android.content.SharedPreferences
import io.mockk.*
import org.junit.Before
import org.junit.Test


class RegisterActivityTest {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    @Before
    fun setUp() {
        sharedPreferences = mockk()
        editor = mockk()

        // Simulación de los métodos de SharedPreferences
        every { sharedPreferences.edit() } returns editor
        every { editor.putString(any(), any()) } returns editor
        every { editor.putLong(any(), any()) } returns editor
        every { editor.apply() } just Runs
    }

    @Test
    fun saveToken_guardaCorrectamenteEnSharedPreferences() {
        // Arrange
        val token = "mi-token"

        // Act
        sharedPreferences.edit().putString("token_key", token).apply()

        // Assert
        verify { sharedPreferences.edit() }
        verify { editor.putString("token_key", token) }
        verify { editor.apply() }
    }

    @Test
    fun saveUserId_guardaCorrectamenteEnSharedPreferences() {
        // Arrange
        val userId: Long = 12345L

        // simulación de obtener SharedPreferences
        every { sharedPreferences.edit() } returns editor

        // Act: guardar el userId
        sharedPreferences.edit().putLong("USER_ID", userId).apply()

        // Assert
        verify { sharedPreferences.edit() }
        verify { editor.putLong("USER_ID", userId) }
        verify { editor.apply() }
    }
}
