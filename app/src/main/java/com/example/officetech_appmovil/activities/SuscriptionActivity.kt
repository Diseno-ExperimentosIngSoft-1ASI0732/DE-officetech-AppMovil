package com.example.officetech_appmovil.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.officetech_appmovil.R

class SuscriptionActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subscription)

        val joinUsButton = findViewById<Button>(R.id.joinUsButton)
        joinUsButton.setOnClickListener {
            val intent = Intent(this, SuscriptionPaymentActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}