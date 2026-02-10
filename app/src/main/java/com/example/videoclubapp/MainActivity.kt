package com.example.videoclubapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Carga el diseño de presentación definido en activity_main.xml
        setContentView(R.layout.activity_main)

        // Handler para pausar la ejecución y crear el efecto de pantalla de carga
        Handler(Looper.getMainLooper()).postDelayed({
            // Crea un Intent explícito para navegar hacia el Menú Principal
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            // Finaliza esta actividad para que el usuario no vuelva a la presentación al dar atrás
            finish()
        }, 5000) // Se mantiene en pantalla durante 5 segundos
    }
}