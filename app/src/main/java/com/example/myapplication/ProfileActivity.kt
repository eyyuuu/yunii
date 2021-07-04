package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.util.toast

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profile = findViewById<ImageButton>(R.id.editprofile)

        profile.setOnClickListener {
            val intentprofile = Intent(this, EditProfileActivity::class.java)
            startActivity(intentprofile)

            toast(this, "succes")
        }

        val logout = findViewById<ImageButton>(R.id.logout)
        logout.setOnClickListener {
            val intentlogot = Intent(this, LoginActivity::class.java)
            startActivity(intentlogot)
        }
    }
}
