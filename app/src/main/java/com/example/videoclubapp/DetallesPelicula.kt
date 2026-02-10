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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pelicula = intent.getSerializableExtra("PELICULA_DATOS") as? Pelicula

        if (pelicula != null) {
            supportActionBar?.title = pelicula.titulo

            val img: ImageView = findViewById(R.id.imgDetalle)
            val titulo: TextView = findViewById(R.id.txtTituloDetalle)
            val genero: TextView = findViewById(R.id.txtGeneroDetalle)
            val desc: TextView = findViewById(R.id.txtDescripcionDetalle)
            val duracion: TextView = findViewById(R.id.txtDuracionDetalle)


            titulo.text = pelicula.titulo
            genero.text = pelicula.genero
            desc.text = pelicula.descripcion
            duracion.text = "${pelicula.duracion} minutos"

            Glide.with(this).load(pelicula.urlImagen).into(img)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}