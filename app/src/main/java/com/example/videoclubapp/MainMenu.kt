package com.example.videoclubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        // Referencia a los botones del menú
        val btnCatalogo = findViewById<Button>(R.id.catalogo_pelis)
        val btnPrecios = findViewById<Button>(R.id.calcular_precios)
        val btnContacto = findViewById<Button>(R.id.contactanos)

        // Navegación al Catálogo de Películas
        btnCatalogo.setOnClickListener {
            startActivity(Intent(this, Catalogo_pelis::class.java))
        }

        // Navegación a la calculadora de alquiler
        btnPrecios.setOnClickListener {
            startActivity(Intent(this, Calcular_precios::class.java))
        }

        // Navegación a la información de contacto
        btnContacto.setOnClickListener {
            startActivity(Intent(this, Contacto::class.java))
        }
    }
}