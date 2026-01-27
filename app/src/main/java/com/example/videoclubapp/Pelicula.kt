package com.example.videoclubapp

import java.io.Serializable

data class Pelicula(
    val titulo: String,
    val genero: String,
    val urlImagen: String,
    val descripcion: String
) : Serializable