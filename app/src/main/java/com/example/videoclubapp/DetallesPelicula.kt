package com.example.videoclubapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetallesPelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        // Habilitar flecha de volver
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Recuperar el objeto película enviado
        val pelicula = intent.getSerializableExtra("PELICULA_DATOS") as? Pelicula

        if (pelicula != null) {
            supportActionBar?.title = pelicula.titulo

            val img: ImageView = findViewById(R.id.imgDetalle)
            val titulo: TextView = findViewById(R.id.txtTituloDetalle)
            val genero: TextView = findViewById(R.id.txtGeneroDetalle)

            titulo.text = pelicula.titulo
            genero.text = "Género: ${pelicula.genero}"
            Glide.with(this).load(pelicula.urlImagen).into(img)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish() // Cierra esta pantalla y vuelve a la anterior
        return true
    }
}