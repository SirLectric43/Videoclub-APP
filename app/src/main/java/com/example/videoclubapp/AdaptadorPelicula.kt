package com.example.videoclubapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdaptadorPelicula(
    private var lista: List<Pelicula>,
    private val onFavoritoClick: (Pelicula) -> Unit
) : RecyclerView.Adapter<AdaptadorPelicula.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPortada: ImageView = view.findViewById(R.id.imgPortada)
        val txtTitulo: TextView = view.findViewById(R.id.txtTitulo)
        val txtGenero: TextView = view.findViewById(R.id.txtGenero)
        val txtDuracion: TextView = view.findViewById(R.id.txtDuracion)
        val btnFavorito: ImageButton = view.findViewById(R.id.btnFavorito)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = lista[position]

        // Asignación de textos a los 3 TextViews
        holder.txtTitulo.text = p.titulo
        holder.txtGenero.text = p.genero
        holder.txtDuracion.text = "${p.duracion} min"

        Glide.with(holder.itemView.context).load(p.urlImagen).into(holder.imgPortada)

        // Estado visual del botón favorito
        val icono = if (p.esFavorita) android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off
        holder.btnFavorito.setImageResource(icono)

        holder.btnFavorito.setOnClickListener {
            p.esFavorita = !p.esFavorita
            notifyItemChanged(position)
            onFavoritoClick(p) // Notifica a Catalogo_pelis para guardar en SharedPreferences
        }

        // Navegación a Detalles (Intent explícito con paso de parámetros)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetallesPelicula::class.java)
            intent.putExtra("PELICULA_DATOS", p)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = lista.size

    fun actualizarLista(nuevaLista: List<Pelicula>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }
}