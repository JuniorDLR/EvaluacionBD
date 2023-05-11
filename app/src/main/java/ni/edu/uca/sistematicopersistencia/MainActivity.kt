package ni.edu.uca.sistematicopersistencia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.sistematicopersistencia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnAdd.setOnClickListener {
            agregarDatos()
        }
    }

    private fun agregarDatos() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)

    }
}