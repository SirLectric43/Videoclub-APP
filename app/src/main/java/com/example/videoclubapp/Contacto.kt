package com.example.videoclubapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Contacto : AppCompatActivity() {

    private val email = "delefue915@g.educaand.es"
    private val telefono = "+34603618120"
    private val direccion = "IES Laguna de Tollón, Av. Blas Infante, s/n, 41749 El Cuervo, Sevilla"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.contactanos)

        val btnContactar = findViewById<Button>(R.id.btnContactar)
        btnContactar.setOnClickListener {
            mostrarOpcionesContacto()
        }
    }

    private fun mostrarOpcionesContacto() {
        val opciones = arrayOf("Enviar Email", "Llamar por teléfono", "Ver en el mapa")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("¿Cómo quieres contactar?")
        builder.setItems(opciones) { _, which ->
            when (which) {
                0 -> enviarEmail()
                1 -> llamarTelefono()
                2 -> abrirMapa()
            }
        }
        builder.show()
    }

    private fun enviarEmail() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
            putExtra(Intent.EXTRA_SUBJECT, "Consulta Videoclub")
        }
        startActivity(Intent.createChooser(intent, "Enviar correo con..."))
    }

    private fun llamarTelefono() {
        // ACTION_DIAL abre el teclado con el número, es más seguro que llamar directamente
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$telefono")
        }
        startActivity(intent)
    }

    private fun abrirMapa() {
        // Busca la dirección directamente en la app de mapas
        val uriMapa = Uri.parse("geo:0,0?q=${Uri.encode(direccion)}")
        val intent = Intent(Intent.ACTION_VIEW, uriMapa)
        intent.setPackage("com.google.android.apps.maps") // Fuerza a usar Google Maps si está instalado
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}