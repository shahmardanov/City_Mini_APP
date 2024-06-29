package com.example.citiesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.citiesapp.databinding.CityModelBinding
import com.example.citiesapp.model.Data

class CityAdapter : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private val cityList = ArrayList<Data>()
    private var selectedPosition = 0

    inner class CityViewHolder(val itemCityBinding: CityModelBinding) :
        RecyclerView.ViewHolder(itemCityBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = CityModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val currentItem = cityList[position]
        holder.itemCityBinding.textViewcityName.text = currentItem.cities

        holder.itemCityBinding.checkBox.isChecked =
            if (position == selectedPosition) true else false

        holder.itemCityBinding.checkBox.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }
        holder.itemCityBinding.cityCard.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }
    }

    fun updateList(cities: List<Data>) {
        cityList.clear()
        cityList.addAll(cities)
        notifyDataSetChanged()
    }
}