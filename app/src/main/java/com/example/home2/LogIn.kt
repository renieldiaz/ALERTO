package com.example.home2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        findViewById<TextView>(R.id.signUpClickable).setOnClickListener { SignUp() }
        findViewById<Button>(R.id.submitBtn).setOnClickListener { HomeActivity() }
    }
    //signup intent
    public fun SignUp(){
        val intent = Intent (this, SignUp::class.java)
        startActivity(intent)
    }
    public fun HomeActivity(){
        val home = Intent(this, MainActivity::class.java)
        startActivity(home)
    }
}

