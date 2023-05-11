package ni.edu.uca.sistematicopersistencia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto

class Adapter() : RecyclerView.Adapter<Adapter.ViewHolder>() {
    val lista = mutableListOf<EntityProducto>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreP = itemView.findViewById<TextView>(R.id.tvNombreProd)
        val precioP = itemView.findViewById<TextView>(R.id.tvPrecioProd)
        val existenciaP = itemView.findViewById<TextView>(R.id.tvPrecioProd)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.card_item_user, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val listP = lista[position]
        holder.nombreP.text = listP.nombre
        holder.existenciaP.text = listP.existencia.toString()
        holder.precioP.text = listP.precio.toInt().toString()
    }

    override fun getItemCount(): Int {
        return lista.size

    }
}