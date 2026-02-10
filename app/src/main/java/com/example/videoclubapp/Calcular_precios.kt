package com.example.videoclubapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoclubapp.databinding.ActivityCalcularPreciosBinding
import java.text.NumberFormat

class Calcular_precios : AppCompatActivity() {

    private lateinit var binding: ActivityCalcularPreciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Uso de ViewBinding para acceder a los componentes de forma segura
        binding = ActivityCalcularPreciosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Calcular Precios"

        binding.botonCalcular.setOnClickListener { calcularPrecio() }
    }

    private fun calcularPrecio() {
        // Obtiene el valor del campo de texto
        val cantidad = binding.costeAlquilerEditText.text.toString().toDoubleOrNull() ?: 0.0
        val esEstreno = binding.peliculaEstreno.isChecked

        // Determina el precio base según el RadioButton seleccionado
        val precioUnitario = when (binding.opcionesAlquiler.checkedRadioButtonId) {
            R.id.opcion_hora -> if (esEstreno) 0.25 else 0.15
            R.id.opcion_dia -> if (esEstreno) 5.99 else 3.99
            R.id.opcion_semana -> if (esEstreno) 40.00 else 25.00
            else -> 0.0
        }

        // Muestra el resultado formateado como moneda local
        val total = cantidad * precioUnitario
        binding.resultadoEstreno.text = "Total: ${NumberFormat.getCurrencyInstance().format(total)}"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}