package com.example.videoclubapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Catalogo_pelis : AppCompatActivity() {

    private lateinit var adaptador: AdaptadorPelicula
    private lateinit var listaCompleta: List<Pelicula>
    private var filtroActual: String = "Todos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_pelis)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Catálogo de Películas"

        val rvPeliculas: RecyclerView = findViewById(R.id.rvPeliculas)
        rvPeliculas.layoutManager = GridLayoutManager(this, 2)

        // 1. Cargamos la lista completa una sola vez
        listaCompleta = obtenerPeliculas()

        // 2. Inicializamos el adaptador pasándole la función lambda para clicks en favoritos
        adaptador = AdaptadorPelicula(listaCompleta) { pelicula ->
            // Si estamos viendo la lista de "Favoritos" y desmarcamos uno,
            // refrescamos la lista para que desaparezca al momento.
            if (filtroActual == "Favoritos" && !pelicula.esFavorita) {
                filtrarPor("Favoritos")
            }
        }
        rvPeliculas.adapter = adaptador

        // 3. Configurar listeners de los botones
        setupFiltros()
    }

    private fun setupFiltros() {
        findViewById<ImageButton>(R.id.btnTodos).setOnClickListener { filtrarPor("Todos") }
        findViewById<ImageButton>(R.id.btnFavoritos).setOnClickListener { filtrarPor("Favoritos") }
        findViewById<ImageButton>(R.id.btnAccion).setOnClickListener { filtrarPor("Acción") }
        findViewById<ImageButton>(R.id.btnComedia).setOnClickListener { filtrarPor("Comedia") }
        findViewById<ImageButton>(R.id.btnTerror).setOnClickListener { filtrarPor("Terror") }
        findViewById<ImageButton>(R.id.btnRomance).setOnClickListener { filtrarPor("Romance") }
    }

    private fun filtrarPor(categoria: String) {
        filtroActual = categoria
        val listaFiltrada = when (categoria) {
            "Todos" -> listaCompleta
            "Favoritos" -> listaCompleta.filter { it.esFavorita }
            else -> listaCompleta.filter { it.genero == categoria }
        }
        adaptador.actualizarLista(listaFiltrada)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    private fun obtenerPeliculas(): List<Pelicula> {
        return listOf(
            // ACCIÓN
            Pelicula("John Wick", "Acción", "https://theposterdb.com/api/assets/17551", "Un ex asesino a sueldo sale de su retiro para rastrear a los gánsteres que mataron a su perro y le robaron su coche.", "101"),
            Pelicula("Karate Kid Legends", "Acción", "https://theposterdb.com/api/assets/595124", "Un joven aprende artes marciales para defenderse y encontrar su lugar en el mundo bajo la tutela de un maestro.", "94"),
            Pelicula("Malditos Bastardos", "Acción", "https://theposterdb.com/api/assets/8608", "En la Francia ocupada, un grupo de soldados judíos planea asesinar a los líderes del Tercer Reich.", "153"),
            Pelicula("The Maze Runner", "Acción", "https://theposterdb.com/api/assets/1026", "Thomas despierta en un laberinto gigante junto a otros jóvenes, sin recordar nada de su pasado.", "113"),
            Pelicula("Pixels", "Acción", "https://theposterdb.com/api/assets/51362", "Expertos en videojuegos son reclutados por el ejército para combatir personajes clásicos que atacan la Tierra.", "105"),

            // COMEDIA
            Pelicula("Minecraft La Película", "Comedia", "https://image.tmdb.org/t/p/original/8jMQ2sVZ1RRiYSpcb7Yommo7V4r.jpg", "Un grupo de aventureros se adentra en el mundo de bloques para salvarlo de fuerzas oscuras.", "101"),
            Pelicula("Padre no hay mas que uno", "Comedia", "https://theposterdb.com/api/assets/439016", "Un padre se queda solo al cargo de sus cinco hijos cuando su mujer se va de viaje de improviso.", "98"),
            Pelicula("Scary Movie", "Comedia", "https://theposterdb.com/api/assets/994", "Una parodia desternillante de las películas de terror más famosas de los años 90.", "88"),
            Pelicula("Dos tontos muy tontos", "Comedia", "https://theposterdb.com/api/assets/12115", "Dos amigos con muy poco intelecto emprenden un viaje épico para devolver un maletín olvidado.", "107"),
            Pelicula("8 Apellidos Vascos", "Comedia", "https://theposterdb.com/api/assets/673848", "Un sevillano que nunca ha salido de su ciudad se hace pasar por vasco para conquistar a una chica.", "98"),

            // TERROR
            Pelicula("IT", "Terror", "https://theposterdb.com/api/assets/164502", "Es una película de terror basada en la novela de Stephen King que sigue al 'Club de los Perdedores', un grupo de niños en Derry, Maine, enfrentando sus miedos contra un ente sobrenatural.", "135"),
            Pelicula("El Exorcista", "Terror", "https://theposterdb.com/api/assets/372164", "Una madre busca ayuda profesional y religiosa cuando su hija empieza a mostrar un comportamiento aterrador.", "122"),
            Pelicula("Hereditary", "Terror", "https://theposterdb.com/api/assets/21170", "Tras la muerte de la matriarca, una familia empieza a descubrir secretos oscuros y perturbadores.", "127"),
            Pelicula("Barbarian", "Terror", "https://theposterdb.com/api/assets/252533", "Una joven alquila una casa y descubre que no está sola, encontrando secretos terroríficos en el sótano.", "103"),
            Pelicula("Talk to Me", "Terror", "https://theposterdb.com/api/assets/357707", "Un grupo de amigos descubre cómo conjurar espíritus usando una mano embalsamada, pero van demasiado lejos.", "95"),

            // ROMANCE
            Pelicula("Casablanca", "Romance", "https://theposterdb.com/api/assets/122862", "Durante la II Guerra Mundial, un expatriado debe decidir si ayuda a su antigua amante y a su marido.", "102"),
            Pelicula("Titanic", "Romance", "https://theposterdb.com/api/assets/48394", "Dos jóvenes de diferentes clases sociales se enamoran a bordo del lujoso e infortunado transatlántico.", "194"),
            Pelicula("La La Land", "Romance", "https://theposterdb.com/api/assets/13422", "Una aspirante a actriz y un músico de jazz se enamoran mientras persiguen sus sueños en Los Ángeles.", "128"),
            Pelicula("Past Lives", "Romance", "https://theposterdb.com/api/assets/356972", "Dos amigos de la infancia se reencuentran años después y reflexionan sobre su relación y el destino.", "106"),
            Pelicula("Anyone But You", "Romance", "https://theposterdb.com/api/assets/446140", "Dos personas que se odian mutuamente deben fingir que son pareja durante una boda en Australia.", "103")
        )
    }
}