package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.model.ModelUser
import com.example.myapplication.util.logAssert
import com.example.myapplication.util.toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val editpassword = findViewById<EditText>(R.id.editpassword)
        val forgetpassword = findViewById<TextView>(R.id.forgetpass)
        val signup = findViewById<TextView>(R.id.signup)

        database = FirebaseDatabase.getInstance().getReference()

        forgetpassword.setOnClickListener {
            val intent = Intent(this, LupaPasswordActivity::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener {
            val intentt = Intent(this, SignUpActivity::class.java)
            startActivity(intentt)
            finish()
        }

        btnEnter.setOnClickListener {

            val email = edtEmail.text.toString()
            val password = editpassword.text.toString()

//            val userListener = object : ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    // Get Post object and use the values to update the UI
////                    val user = dataSnapshot.getValue<ModelUser>()
//                    logAssert("datasnapshoot", "$dataSnapshot")
//                    logAssert("user", "${dataSnapshot.getValue(ModelUser::class.java)}")
//                    dataSnapshot.children.forEach {
//                        val user = it.getValue(ModelUser::class.java)
//                        logAssert("data", "${it.getValue(ModelUser::class.java)}")
//                        if (email == user?.email && password == user.password) {
//                            val enter = Intent(this@LoginActivity, MenuUtamaActivity::class.java)
//                            startActivity(enter)
//                            finish()
//                            return
//                        } else {
//                            toast(this@LoginActivity, "Akun belum terdaftar")
//                        }
//                    }
//                }
//
//                override fun onCancelled(databaseError: DatabaseError) {
//                    // Getting Post failed, log a message
//                    logAssert("error", "terjadi kesalahan")
//                    toast(this@LoginActivity, "Terjadi kesalahan")
//                }
//            }

            val query: Query = database.child("users").orderByChild("email").equalTo(email)
            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    logAssert("dataSnapshot", "$dataSnapshot")
                    logAssert("dataSnapshot.exists()", "${dataSnapshot.exists()}")
                    if (dataSnapshot.exists()) {
                        dataSnapshot.children.forEach {
                            val user = it.getValue(ModelUser::class.java)

                            if (password.equals(user?.password)) {
                                toast(this@LoginActivity,"Berhasil")
                                val enter = Intent(this@LoginActivity, MenuUtamaActivity::class.java)
                                startActivity(enter)
                                finish()
                            } else {
                                toast(this@LoginActivity,"Password salah")
                            }
                        }
                    } else {
                        toast(this@LoginActivity,"Email belum terdaftar")
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })

//            database.child("users").addListenerForSingleValueEvent(userListener)

        }
    }
}
