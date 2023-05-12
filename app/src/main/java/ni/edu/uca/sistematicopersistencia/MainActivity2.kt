package ni.edu.uca.sistematicopersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos.Companion.obtBaseDatos
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.databinding.ActivityAddBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnAgregarP.setOnClickListener {
            agregarP()
        }
    }

    private fun agregarP() {
        val nombreP = binding.etNombreP.text.toString()
        val precioP = binding.etPrecioP.text.toString().toDoubleOrNull()
        val existenciaP = binding.etExistenciaP.text.toString().toIntOrNull()

        if (nombreP.isNotEmpty() && precioP != null && existenciaP != null) {
            val entity =
                EntityProducto(nombre = nombreP, precio = precioP, existencia = existenciaP)

            lifecycleScope.launch {
                obtBaseDatos(this@MainActivity2).productoDao().insertarReg(entity)
                finish()
            }
        } else {
            Toast.makeText(this, "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}
