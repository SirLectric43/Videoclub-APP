package com.example.videoclubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCatalogo_Pelis = findViewById<Button>(R.id.catalogo_pelis)
        val btnCalcular_Precios = findViewById<Button>(R.id.calcular_precios)
        val btnContacto = findViewById<Button>(R.id.contactanos)

        btnCatalogo_Pelis.setOnClickListener {
            val intent = Intent(this, Catalogo_pelis::class.java)
            startActivity(intent)
        }

        btnCalcular_Precios.setOnClickListener {
            val intent = Intent(this, Calcular_precios::class.java)
            startActivity(intent)
        }

        btnContacto.setOnClickListener {
            val intent = Intent(this, Contacto::class.java)
            startActivity(intent)
        }
    }
}