package ni.edu.uca.sistematicopersistencia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos.Companion.obtBaseDatos
import ni.edu.uca.sistematicopersistencia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var Adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        obtenerProductos()

        binding.btnAdd.setOnClickListener {
            agregarDatos()
        }

        binding.recyclerview.adapter = Adapter
        val layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerview.layoutManager = layoutManager


    }


    private fun agregarDatos() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)

    }

    private fun obtenerProductos() {
        lifecycleScope.launch {
            val listaProductos = obtBaseDatos(this@MainActivity).productoDao().obtRegistos()
                .toList() // Transformar Flow en lista

            binding.recyclerview.adapter = Adapter().apply {
                lista.clear()
                lista.addAll(listaProductos)
                notifyDataSetChanged()
            }
        }

    }
}
