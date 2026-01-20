package com.example.videoclubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class catalogo_pelis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_pelis)

        // --- NUEVO: Habilitar la flecha de retroceso en la barra superior ---
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.catalogo_pelis) // Poner título a la barra

    }

    override fun onSupportNavigateUp(): Boolean {
        // Vuelve a la actividad padre declarada en el Manifest (MainActivity)
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}