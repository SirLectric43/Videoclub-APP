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

// [Modificado] Ahora la lista es var para poder cambiarla y añadimos un listener
class AdaptadorPelicula(
    private var lista: List<Pelicula>,
    private val onFavoritoClick: (Pelicula) -> Unit // Callback para avisar al activity
) : RecyclerView.Adapter<AdaptadorPelicula.ViewHolder>() {

    // Clase interna que mantiene las referencias a las vistas de cada tarjeta
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPortada: ImageView = view.findViewById(R.id.imgPortada)
        val txtTitulo: TextView = view.findViewById(R.id.txtTitulo)
        val txtGenero: TextView = view.findViewById(R.id.txtGenero)
        val btnFavorito: ImageButton = view.findViewById(R.id.btnFavorito)
    }

    // Infla el diseño item_pelicula.xml para cada elemento de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = lista[position]

        // Asigna los textos a los 2 TextViews
        holder.txtTitulo.text = p.titulo
        holder.txtGenero.text = p.genero

        Glide.with(holder.itemView.context)
            .load(p.urlImagen)
            .placeholder(android.R.drawable.progress_horizontal)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.imgPortada)

        // Configurar icono de favorito
        val icono = if (p.esFavorita) android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off
        holder.btnFavorito.setImageResource(icono)

        holder.btnFavorito.setOnClickListener {
            p.esFavorita = !p.esFavorita
            notifyItemChanged(position) // Actualiza solo este item visualmente
            onFavoritoClick(p) // Avisa a la actividad (por si hay que refrescar filtros)
        }

        holder.itemView.setOnClickListener {
            val contexto = holder.itemView.context
            val intent = Intent(contexto, DetallesPelicula::class.java)
            intent.putExtra("PELICULA_DATOS", p)
            contexto.startActivity(intent)
        }
    }

    override fun getItemCount() = lista.size

    // Metodo para filtrar la lista
    fun actualizarLista(nuevaLista: List<Pelicula>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }
}