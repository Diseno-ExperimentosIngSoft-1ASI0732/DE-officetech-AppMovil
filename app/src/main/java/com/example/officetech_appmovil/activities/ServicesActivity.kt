package com.example.officetech_appmovil.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.officetech_appmovil.R

class ServicesActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.services)

        val homeNav = findViewById<TextView>(R.id.homeNav)
        val profileNav = findViewById<TextView>(R.id.profileNav)
        val historyNav = findViewById<TextView>(R.id.historyNav)

        homeNav.setOnClickListener {
            val intent = Intent(this, AppHomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}