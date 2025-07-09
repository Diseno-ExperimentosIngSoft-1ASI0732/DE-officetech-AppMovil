package com.example.officetech_appmovil.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.officetech_appmovil.R
import com.example.officetech_appmovil.adapters.AppDatabase
import com.example.officetech_appmovil.communication.PaymentResponse
import com.example.officetech_appmovil.models.Payment
import com.example.officetech_appmovil.network.PaymentService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuscriptionPaymentActivity:AppCompatActivity() {
//    private lateinit var token: String
//    private var userId: Int = -1
//    private lateinit var service: PaymentService
//    private lateinit var sharedPreferences: SharedPreferences  // NUEVO
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.subscription_payment)
//        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE) // NUEVO
//
//
//        token = getToken()
//        userId = intent.getIntExtra("USER_ID", -1)
//
//        if (token.isEmpty() || userId == -1) {
//            Toast.makeText(this, "Error: token o usuario no disponible", Toast.LENGTH_SHORT).show()
//            finish()
//            return
//        }
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://de-officetech-backend.onrender.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        service = retrofit.create(PaymentService::class.java)
//
//        val etCardHolderName = findViewById<EditText>(R.id.cardholderNameEditText)
//        val etCardNumber = findViewById<EditText>(R.id.cardNumberEditText)
//        val etExpiratoryMonth = findViewById<EditText>(R.id.expirationMonthEditText)
//        val etExpiratoryYear = findViewById<EditText>(R.id.expirationYearEditText)
//        val etCVV = findViewById<EditText>(R.id.cvvEditText)
//        val payButton = findViewById<Button>(R.id.payButton)
//
//        payButton.setOnClickListener {
//            if (
//                etCardHolderName.text.isNullOrEmpty() ||
//                etCardNumber.text.isNullOrEmpty() ||
//                etExpiratoryMonth.text.isNullOrEmpty() ||
//                etExpiratoryYear.text.isNullOrEmpty() ||
//                etCVV.text.isNullOrEmpty()
//            ) {
//                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            val payment = Payment(
//                cardHolderName = etCardHolderName.text.toString(),
//                cardNumber = etCardNumber.text.toString(),
//                expiratoryMonth = etExpiratoryMonth.text.toString(),
//                expiratoryYear = etExpiratoryYear.text.toString(),
//                cvv = etCVV.text.toString(),
//                userId = userId
//            )
//
//            enviarPago(payment)
//        }
//    }
//
//    private fun enviarPago(payment: Payment) {
//        val call = service.createPayment("Bearer $token", payment)
//
//        call.enqueue(object : Callback<PaymentResponse> {
//            override fun onResponse(call: Call<PaymentResponse>, response: Response<PaymentResponse>) {
//                if (response.isSuccessful) {
//                    guardarPagoEnBaseDeDatos(payment)
//
//                    val editor = sharedPreferences.edit()
//                    editor.putBoolean("IS_SUBSCRIBED", true)
//                    editor.apply()
//
//                    Toast.makeText(this@SuscriptionPaymentActivity, "Pago registrado exitosamente", Toast.LENGTH_SHORT).show()
//
//                    val intent = Intent(this@SuscriptionPaymentActivity, AppHomeActivity::class.java)
//                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                    startActivity(intent)
//                    finish()
//                } else {
//                    Log.e("PaymentError", "Error: ${response.code()} - ${response.errorBody()?.string()}")
//                    Toast.makeText(this@SuscriptionPaymentActivity, "Error al registrar el pago", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<PaymentResponse>, t: Throwable) {
//                Log.e("PaymentError", "Fallo en la solicitud: ${t.message}")
//                Toast.makeText(this@SuscriptionPaymentActivity, "Fallo de red", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//
//    private fun guardarPagoEnBaseDeDatos(payment: Payment) {
//        val database = AppDatabase.getDatabase(applicationContext)
//
//        Thread {
//            val paymentDao = database.paymentDAO()
//            val rowId = paymentDao.insertPayment(payment)
//
//            if (rowId > 0) {
//                Log.d("Database", "Pago guardado correctamente con ID: $rowId")
//            } else {
//                Log.e("Database", "Error al guardar el pago")
//            }
//        }.start()
//    }
//
//    private fun getToken(): String {
//        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
//        return sharedPreferences.getString("USER_TOKEN", "") ?: ""
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subscription_payment)

        val payButton = findViewById<Button>(R.id.payButton)
        payButton.setOnClickListener {
            val intent = Intent(this, AppHomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}