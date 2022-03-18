package com.lauwba.wisatakita.destinasi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lauwba.wisatakita.databinding.ItemDestinasiBinding

class DestinasiAdapter(
    private val listDestinasi: List<Destinasi>,
    private var onMapClickListener: (Destinasi) -> Unit ) : RecyclerView.Adapter<DestinasiAdapter.ViewHolder>() {

    inner class ViewHolder(val itemDestinasiBinding: ItemDestinasiBinding) : RecyclerView.ViewHolder(itemDestinasiBinding.root) {
        fun onBindItem(destinasi: Destinasi) {
            itemDestinasiBinding.rating.text = destinasi.rating.toString()
            itemDestinasiBinding.namaDestinasi.text = destinasi.namaDestinasi
            itemDestinasiBinding.location.text = destinasi.location

            Glide.with(itemDestinasiBinding.root.context)
                .load(destinasi.fotoDestinasi)
                .into(itemDestinasiBinding.destinasiImageItem)

            itemDestinasiBinding.viewOnMap.setOnClickListener{
                onMapClickListener(destinasi)
            }
            itemDestinasiBinding.destinasiImageItem.setOnClickListener {
                onMapClickListener(destinasi)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDestinasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindItem(listDestinasi[position])
    }

    override fun getItemCount(): Int = listDestinasi.size
}