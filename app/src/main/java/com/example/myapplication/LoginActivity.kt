package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val btnEnter = findViewById<Button>(R.id.btnEnter)

        btnEnter.setOnClickListener {
            val email = edtEmail.text
            Toast.makeText(this, email, Toast.LENGTH_SHORT).show()
        }
    }
}
