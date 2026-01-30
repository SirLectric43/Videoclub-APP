package com.example.videoclubapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Espera 2 segundos y salta al Menú
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainMenu::class.java))
            finish()
        }, 5000)
    }
}