package com.lauwba.wisatakita.galeri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lauwba.wisatakita.R
import com.lauwba.wisatakita.databinding.ItemGaleriAdapterBinding

class GaleriAdapter(
    private val listImage: Array<String>,
    private val onImageClick: (Array<String>, Int) -> Unit) : RecyclerView.Adapter<GaleriAdapter.ViewHolder>() {

    inner class ViewHolder(val itemGaleriAdapterBinding: ItemGaleriAdapterBinding) : RecyclerView.ViewHolder(itemGaleriAdapterBinding.root) {
        fun onBindItem(url: String, position: Int) {
            Glide.with(itemGaleriAdapterBinding.root.context)
                .load(url)
                .into(itemGaleriAdapterBinding.imageItem)

            itemGaleriAdapterBinding.imageItem.setOnClickListener {
                onImageClick(listImage, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGaleriAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindItem(listImage[position], position)
    }

    override fun getItemCount(): Int = listImage.size
}