package com.example.videoclubapp

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.videoclubapp.databinding.ActivityCalcularPreciosBinding
import java.text.NumberFormat

class calcular_precios : AppCompatActivity() {

    private lateinit var binding: ActivityCalcularPreciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcularPreciosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- NUEVO: Habilitar la flecha de retroceso en la barra superior ---
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.calcular_precios) // Poner título a la barra

        // Configurar botones y listeners
        binding.botonCalcular.setOnClickListener { calcularPrecio() }

        binding.costeAlquilerEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(view, keyCode)
        }
    }

    // --- NUEVO: Gestionar la acción de volver atrás ---
    override fun onSupportNavigateUp(): Boolean {
        // Vuelve a la actividad padre declarada en el Manifest (MainActivity)
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    private fun calcularPrecio() {
        val stringInTextField = binding.costeAlquilerEditText.text.toString()
        val cantidad = stringInTextField.toDoubleOrNull()

        if (cantidad == null || cantidad == 0.0) {
            mostrarResultado(0.0)
            return
        }

        val esEstreno = binding.peliculaEstreno.isChecked

        val precioUnitario = when (binding.opcionesAlquiler.checkedRadioButtonId) {
            R.id.opcion_hora -> if (esEstreno) 0.25 else 0.15
            R.id.opcion_dia -> if (esEstreno) 5.99 else 3.99
            R.id.opcion_semana -> if (esEstreno) 40.00 else 25.00
            else -> 0.0
        }

        val total = cantidad * precioUnitario
        mostrarResultado(total)
    }

    private fun mostrarResultado(monto: Double) {
        val formatoMoneda = NumberFormat.getCurrencyInstance()
        val precioFormateado = formatoMoneda.format(monto)
        binding.resultadoEstreno.text = "Total precio de alquiler: $precioFormateado"
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}