package com.ibrahim.retrofitkandillii.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.retrofitkandillii.databinding.ItemPlaceBinding
import com.ibrahim.retrofitkandillii.model.PlaceItem

class PlaceAdapter() : RecyclerView.Adapter<PlaceAdapter.PlaceVH>() {

    private var placeList: ArrayList<PlaceItem?> = arrayListOf()

    fun setList(newList: List<PlaceItem?>) {
        this.placeList.clear()
        this.placeList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class PlaceVH(val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceVH {
        return PlaceVH(ItemPlaceBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PlaceVH, position: Int) {
        val place=placeList[position]

        holder.binding.tvPlaceLocation.text=place?.lokasyon
        holder.binding.tvPlaceDate.text=place?.date
        holder.binding.tvPlaceCoordinates.text = place?.coordinates.toString()
        holder.binding.tvPlaceMag.text = place?.mag.toString()

    }

    override fun getItemCount(): Int = placeList.size

}