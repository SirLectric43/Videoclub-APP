package com.example.videoclubapp

import java.io.Serializable

// Clase de datos que representa una película.
// Implementa Serializable para poder pasar el objeto completo entre actividades mediante Intents.
data class Pelicula(
    val titulo: String,      // Nombre de la película
    val genero: String,      // Categoría (Acción, Comedia, etc.)
    val urlImagen: String,   // Enlace a la imagen de portada
    val descripcion: String, // Sinopsis detallada
    val duracion: String,    // Duración en minutos (requerido para el 3er TextView del RecyclerView)
    var esFavorita: Boolean = false // Estado de favorito (por defecto falso)
) : Serializable