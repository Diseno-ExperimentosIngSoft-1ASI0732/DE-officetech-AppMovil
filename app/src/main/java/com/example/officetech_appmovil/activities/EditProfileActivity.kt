package com.example.officetech_appmovil.activities

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.officetech_appmovil.R
import android.widget.Button
class EditProfileActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        val firstName = findViewById<EditText>(R.id.firstNameEditText)
        val lastName = findViewById<EditText>(R.id.lastNameEditText)
        val email = findViewById<EditText>(R.id.emailEditText)
        val phone = findViewById<EditText>(R.id.phoneEditText)
        val password = findViewById<EditText>(R.id.passwordEditText)

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val saveButton = findViewById<Button>(R.id.saveButton)

        cancelButton.setOnClickListener {
            finish()
        }

        saveButton.setOnClickListener {

        }
    }
}