package uts.c14240190.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import uts.c14240190.recyclerview.databinding.ItemRecyclerBinding

class adapterRevView (private val listWayang: ArrayList<dcWayang>) :
    RecyclerView.Adapter<adapterRevView.ListViewHolder>(){

    inner class ListViewHolder(val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val binding = ItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listWayang.size
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        val wayang = listWayang[position]
        holder.binding.namaWayang.text = wayang.nama
        holder.binding.karakterWayang.text = wayang.karakter
        holder.binding.deskripsiWayang.text = wayang.deskripsi

        val circularProgressDrawable = CircularProgressDrawable(holder.itemView.context).apply{
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }

        holder.binding.gambarWayang.load(wayang.foto){
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
            error(R.drawable.ic_launcher_background)
        }
    }
}