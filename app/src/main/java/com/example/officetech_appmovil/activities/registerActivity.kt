package com.example.officetech_appmovil.activities

import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import retrofit2.Callback
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.officetech_appmovil.R
import com.example.officetech_appmovil.adapters.AppDatabase
import com.example.officetech_appmovil.communication.AuthResponse
import com.example.officetech_appmovil.models.User
import com.example.officetech_appmovil.models.UserAuth
import com.example.officetech_appmovil.network.UserService
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class registerActivity:AppCompatActivity() {
    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_app)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userService = retrofit.create(UserService::class.java)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val signupButton = findViewById<Button>(R.id.signupButton)
        val loginText = findViewById<TextView>(R.id.loginText)
        val roleRadioGroup = findViewById<RadioGroup>(R.id.roleRadioGroup)

        signupButton.setOnClickListener {
            val selectedRoleId = roleRadioGroup.checkedRadioButtonId
            val role = when (selectedRoleId) {
                R.id.clientRadio -> "ROLE_ADMIN"
                R.id.technicianRadio -> "ROLE_TECHNICIAN"
                else -> ""
            }

            if (role.isEmpty()) {
                Toast.makeText(this, "Por favor selecciona un rol", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(
                firstName = etFirstName.text.toString(),
                lastName = etLastName.text.toString(),
                email = etEmail.text.toString(),
                password = etPassword.text.toString(),
                role = role
            )

            val auth = UserAuth(
                username = etEmail.text.toString(),
                password = etPassword.text.toString()
            )

            userService.registerAuthUser(auth).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        userService.loginUser(auth).enqueue(object : Callback<AuthResponse> {
                            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                                if (response.isSuccessful) {
                                    val token = response.body()?.token
                                    if (token != null) {
                                        saveToken(token)

                                        userService.registerUserDataWithAuth("Bearer $token", user).enqueue(object : Callback<User> {
                                            override fun onResponse(call: Call<User>, response: Response<User>) {
                                                if (response.isSuccessful) {
                                                    val userResponse = response.body()
                                                    if (userResponse != null) {
                                                        saveUserId(userResponse.id?.toLong() ?: -1L)   // Guardar el ID del usuario
                                                    }
                                                    Toast.makeText(this@registerActivity, "Registro exitoso", Toast.LENGTH_SHORT).show()
                                                    startActivity(Intent(this@registerActivity, SuscriptionActivity::class.java))
                                                } else {
                                                    Toast.makeText(this@registerActivity, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                                                }
                                            }

                                            override fun onFailure(call: Call<User>, t: Throwable) {
                                                Toast.makeText(this@registerActivity, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                                            }
                                        })
                                    } else {
                                        Toast.makeText(this@registerActivity, "Token no recibido", Toast.LENGTH_SHORT).show()
                                    }
                                } else {
                                    Toast.makeText(this@registerActivity, "Error de autenticación", Toast.LENGTH_SHORT).show()
                                }
                            }

                            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                                Toast.makeText(this@registerActivity, "Error de autenticación", Toast.LENGTH_SHORT).show()
                            }
                        })
                    } else {
                        Toast.makeText(this@registerActivity, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.e("RegisterActivity", "Fallo en la solicitud de registro: ${t.message}")
                    Toast.makeText(this@registerActivity, "Error en el registro", Toast.LENGTH_SHORT).show()
                }
            })
        }

        loginText.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
        }
    }

    public fun saveToken(token: String) {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("USER_TOKEN", token)
        editor.apply()
    }

    public fun saveUserId(userId: Long) {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong("USER_ID", userId)
        editor.apply()
    }

}