package com.ibrahim.retrofitkandillii.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.retrofitkandillii.R
import com.ibrahim.retrofitkandillii.model.PlaceResponse
import kotlinx.android.synthetic.main.item_place.view.*

class PlaceAdapter : RecyclerView.Adapter<PlaceAdapter.PlaceVH>() {

    private var PlaceDataList: ArrayList<PlaceResponse.Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlaceVH(
        LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
    )

    override fun onBindViewHolder(holder: PlaceAdapter.PlaceVH, position: Int) {
        holder.bind(PlaceDataList[position])
    }

    override fun getItemCount(): Int = PlaceDataList.size

    inner class PlaceVH(view: View) : RecyclerView.ViewHolder(view){
        fun bind(s: PlaceResponse.Result) {
            itemView.tv_place_location.text = s.lokasyon
            itemView.tv_place_date.text=s.dateStamp
            itemView.tv_place_coordinates.text=s.coordinates.toString()
            itemView.tv_place_mag.text = s.mag.toString()
        }
    }

    fun setPlaceNameList(listPlace: ArrayList<PlaceResponse.Result>){
        PlaceDataList.clear()
        PlaceDataList.addAll(listPlace)
        notifyDataSetChanged()
    }

    fun clear(){
        PlaceDataList.clear()
        notifyDataSetChanged()
    }
}