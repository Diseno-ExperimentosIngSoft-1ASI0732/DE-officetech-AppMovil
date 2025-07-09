package com.example.officetech_appmovil.activities

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.officetech_appmovil.R
import com.example.officetech_appmovil.communication.AuthResponse
import com.example.officetech_appmovil.models.UserAuth
import com.example.officetech_appmovil.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LogInActivity:AppCompatActivity() {


    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://de-officetech-backend.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val userService = retrofit.create(UserService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_app)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.signInButton)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Por favor, ingresa tus credenciales", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginUser(username: String, password: String) {
        val auth = UserAuth(username = username, password = password)

        userService.loginUser(auth).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {
                    val authResponse = response.body()
                    val token = authResponse?.token
                    if (token != null) {
                        startActivity(Intent(this@LogInActivity, AppHomeActivity::class.java))
                        Toast.makeText(applicationContext, "Login exitoso", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(applicationContext, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Error de conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun saveToken(token: String) {
        val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("auth_token", token)
        editor.apply()
    }

}