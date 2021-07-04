package com.example.myapplication.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class ModelUser(
    val fullName: String? = null,
    val email: String? = null,
    val password: String? = null,
    val confirm_password: String? = null
)
