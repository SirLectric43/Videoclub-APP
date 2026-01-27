package com.example.videoclubapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Contacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contacto)

        // --- NUEVO: Habilitar la flecha de retroceso en la barra superior ---
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.contactanos) // Poner título a la barra

    }

    override fun onSupportNavigateUp(): Boolean {
        // Vuelve a la actividad padre declarada en el Manifest (MainActivity)
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}