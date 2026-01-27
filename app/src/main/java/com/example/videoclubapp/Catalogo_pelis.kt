package com.example.videoclubapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Catalogo_pelis : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_pelis)

        // Configuración de la barra superior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Catálogo de Películas"

        // 1. Buscamos el RecyclerView en el layout
        val rvPeliculas: RecyclerView = findViewById(R.id.rvPeliculas)

        // 2. Configuramos el diseño (Grid de 2 columnas para que parezca un videoclub)
        rvPeliculas.layoutManager = GridLayoutManager(this, 2)

        // 3. Obtenemos los datos y los pasamos al adaptador
        val listaDePelis = obtenerPeliculas()
        rvPeliculas.adapter = AdaptadorPelicula(listaDePelis)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    private fun obtenerPeliculas(): List<Pelicula> {
        return listOf(
            // ACCIÓN
            Pelicula("John Wick 1", "Acción", "https://image.tmdb.org/t/p/w500/fZ7Sj4S98m4YvH9h8L1O3T8T6X4.jpg"),
            Pelicula("Karate Kid Legends", "Acción", "https://image.tmdb.org/t/p/w500/mS09M6pIq98r0uK4262h9vFvYI5.jpg"),
            Pelicula("Malditos Bastardos", "Acción", "https://image.tmdb.org/t/p/w500/7is7l4Y93X8A8w2C6D4yv6Y2m8A.jpg"),
            Pelicula("The Maze Runner 1", "Acción", "https://image.tmdb.org/t/p/w500/668Sdf8Y86YI4S4T1rL16S7YF6w.jpg"),
            Pelicula("Pixels", "Acción", "https://image.tmdb.org/t/p/w500/v9D68G6R3X5Z8q6Y6X8R8W7X9vY.jpg"),

            // COMEDIA
            Pelicula("Minecraft The Movie", "Comedia", "https://image.tmdb.org/t/p/w500/6yYJ9mYF8r6P6l9S2v7S4eB9p6O.jpg"),
            Pelicula("Padre no hay mas que uno", "Comedia", "https://image.tmdb.org/t/p/w500/vGv08K1tIAtFh2r0lH2y98V2vB8.jpg"),
            Pelicula("Scary Movie 1", "Comedia", "https://image.tmdb.org/t/p/w500/961tD1H3O4N7X3u0X9u0X9u0X9u.jpg"),
            Pelicula("Dos tontos muy tontos", "Comedia", "https://image.tmdb.org/t/p/w500/499K78S6G8jX7W9G6G6o6o7O7o7.jpg"),
            Pelicula("8 Apellidos Vascos", "Comedia", "https://image.tmdb.org/t/p/w500/f6q3mS8S6G8jX7W9G6G6o6o7O7o.jpg"),

            // TERROR
            Pelicula("Psicosis", "Terror", "https://image.tmdb.org/t/p/w500/81995X7W9G6G6o6o7O7o7O7o7O.jpg"),
            Pelicula("El Exorcista", "Terror", "https://image.tmdb.org/t/p/w500/6yP6M8U8B8U8B8U8B8U8B8U8B8U.jpg"),
            Pelicula("Hereditary", "Terror", "https://image.tmdb.org/t/p/w500/4S9S7S8S9S7S8S9S7S8S9S7S8S9.jpg"),
            Pelicula("Barbarian", "Terror", "https://image.tmdb.org/t/p/w500/idT5X5B8B9B9B9B9B9B9B9B9B9B.jpg"),
            Pelicula("Talk to Me", "Terror", "https://image.tmdb.org/t/p/w500/kdP16X8S9S7S8S9S7S8S9S7S8S9.jpg"),

            // ROMANCE
            Pelicula("Casablanca", "Romance", "https://image.tmdb.org/t/p/w500/9xj7rB6R3X5Z8q6Y6X8R8W7X9vY.jpg"),
            Pelicula("Titanic", "Romance", "https://image.tmdb.org/t/p/w500/9xj7rB6R3X5Z8q6Y6X8R8W7X9vY.jpg"),
            Pelicula("La La Land", "Romance", "https://image.tmdb.org/t/p/w500/u76S8G6R3X5Z8q6Y6X8R8W7X9vY.jpg"),
            Pelicula("Past Lives", "Romance", "https://image.tmdb.org/t/p/w500/PastLivesPath.jpg"),
            Pelicula("Anyone But You", "Romance", "https://image.tmdb.org/t/p/w500/AnyoneButYouPath.jpg")
        )
    }
}