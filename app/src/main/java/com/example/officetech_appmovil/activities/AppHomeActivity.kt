package com.example.officetech_appmovil.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.officetech_appmovil.R

class AppHomeActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_home_main)

        val tvServices = findViewById<TextView>(R.id.tvServices)
        val tvForum = findViewById<TextView>(R.id.tvForum)
        val tvProfile = findViewById<TextView>(R.id.tvProfile)
        val tvLogout = findViewById<TextView>(R.id.tvLogout)


        tvServices.setOnClickListener {
            startActivity(Intent(this, ServicesActivity::class.java))
        }

        tvForum.setOnClickListener{
            startActivity(Intent(this, ForumActivity::class.java))
        }

        tvProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        tvLogout.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }
    }
}