package com.example.officetech_appmovil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.officetech_appmovil.activities.LogInActivity
import com.example.officetech_appmovil.activities.TermsActivity
import com.example.officetech_appmovil.activities.registerActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Aquí enlazamos los botones y les damos funcionalidad
        val loginButton = findViewById<Button>(R.id.loginButton)
        val signupButton = findViewById<Button>(R.id.signupButton)

        loginButton.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        signupButton.setOnClickListener {
            showTermsAndConditionsDialog();
        }
    }
    private fun showTermsAndConditionsDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Términos y Condiciones")
        builder.setMessage("Por favor, lee y acepta los Términos y Condiciones antes de registrarte.")

        builder.setPositiveButton("Ver Términos") { dialog, _ ->
            val intent = Intent(this, TermsActivity::class.java)
            startActivity(intent)
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }

        builder.setNeutralButton("Aceptar") { dialog, _ ->
            val intent = Intent(this, registerActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
        }

        builder.show()
    }
}
