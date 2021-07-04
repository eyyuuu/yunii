package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.ModelUser
import com.example.myapplication.util.logAssert
import com.example.myapplication.util.toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class SignUpActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val edtFullName = findViewById<EditText>(R.id.edt_full_name)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtPassword = findViewById<EditText>(R.id.edt_ppassword)
        val edtConfirm_password = findViewById<EditText>(R.id.edt_confirm_password)
        val btnRegister = findViewById<Button>(R.id.btn_register)
        val btnSignin = findViewById<TextView>(R.id.btn_signin)

        database = FirebaseDatabase.getInstance().getReference()

        btnRegister.setOnClickListener {
            val fullName =  edtFullName.text.toString()
            val email =  edtEmail.text.toString()
            val password =  edtPassword.text.toString()
            val confirmPassword = edtConfirm_password.text.toString()

            val query: Query = database.child("users").orderByChild("email").equalTo(email)
            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    logAssert("dataSnapshot", "$dataSnapshot")
                    logAssert("dataSnapshot.exists()", "${dataSnapshot.exists()}")
                    if (dataSnapshot.exists()) {
                        toast(this@SignUpActivity,"Data sudah ada")
                    } else {
                        toast(this@SignUpActivity,"Berhasil")
                        val dataUser = ModelUser(fullName,email, password)
                        database.child("users").push().setValue(dataUser)
                        val intent = Intent(this@SignUpActivity, MenuUtamaActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })

        }

        btnSignin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
