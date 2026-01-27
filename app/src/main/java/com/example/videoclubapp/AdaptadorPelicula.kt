package com.example.videoclubapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdaptadorPelicula(private val lista: List<Pelicula>) : RecyclerView.Adapter<AdaptadorPelicula.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPortada: ImageView = view.findViewById(R.id.imgPortada)
        val txtTitulo: TextView = view.findViewById(R.id.txtTitulo)
        val txtGenero: TextView = view.findViewById(R.id.txtGenero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return ViewHolder(view)
    }

    // Dentro de PeliculaAdapter.kt, modifica el onBindViewHolder:

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = lista[position]
        holder.txtTitulo.text = p.titulo
        holder.txtGenero.text = p.genero

        Glide.with(holder.itemView.context).load(p.urlImagen).into(holder.imgPortada)

        // --- NUEVO: Configurar el clic ---
        holder.itemView.setOnClickListener {
            val contexto = holder.itemView.context
            val intent = Intent(contexto, DetallesPelicula::class.java)

            // Pasamos el objeto película entero a la siguiente pantalla
            intent.putExtra("PELICULA_DATOS", p)

            contexto.startActivity(intent)
        }
    }

    override fun getItemCount() = lista.size
}