package ni.edu.uca.sistematicopersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos.Companion.obtBaseDatos
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.databinding.ActivityAddBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private var entityProducto: EntityProducto? = null
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
        val precioP = binding.etPrecioP.text.toString()
        val existenciaP = binding.etExistenciaP.text.toString()


        lifecycleScope.launch {
            if (entityProducto == null) {
                val entity =
                    EntityProducto(nombre = nombreP, precio = precioP, existencia = existenciaP)
                obtBaseDatos(this@MainActivity2).productoDao().insertarReg(entity)
            }
            else {

                val u = EntityProducto(nombre = nombreP, precio = precioP, existencia = existenciaP)
                obtBaseDatos(this@MainActivity2).productoDao().obtRegistos(u)
                finish()


            }
        }
    }
}