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

        // Recupera el objeto Pelicula enviado desde el adaptador
        val pelicula = intent.getSerializableExtra("PELICULA_DATOS") as? Pelicula

        if (pelicula != null) {
            supportActionBar?.title = pelicula.titulo

            // Asigna los datos a las vistas del layout
            findViewById<TextView>(R.id.txtTituloDetalle).text = pelicula.titulo
            findViewById<TextView>(R.id.txtGeneroDetalle).text = pelicula.genero
            findViewById<TextView>(R.id.txtDuracionDetalle).text = "${pelicula.duracion} minutos"
            findViewById<TextView>(R.id.txtDescripcionDetalle).text = pelicula.descripcion

            val img: ImageView = findViewById(R.id.imgDetalle)
            Glide.with(this).load(pelicula.urlImagen).into(img)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}