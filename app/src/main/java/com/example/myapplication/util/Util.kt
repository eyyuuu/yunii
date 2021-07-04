package com.example.myapplication.util

import android.content.Context
import android.util.Log
import android.widget.Toast

fun logAssert(tag: String, msg: String) {
    Log.println(Log.ASSERT, tag,msg)
}

fun toast(context: Context, msg: String)  {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}