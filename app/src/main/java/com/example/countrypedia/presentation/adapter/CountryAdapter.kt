package com.example.countrypedia.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countrypedia.R
import com.example.countrypedia.data.remote.dto.CountryDTOElement
import com.example.countrypedia.domain.model.Country

class CountryAdapter(var list : List<CountryDTOElement>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    lateinit var countryName : TextView
    lateinit var countryImage : ImageView

    class CountryViewHolder(var view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.country_row_item,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        countryImage = holder.view.findViewById(R.id.countryFlagImageView)
        countryName = holder.view.findViewById(R.id.countryNameTextView)

        countryName.text = list.get(position).name.common
        Glide.with(holder.view).load(list.get(position).flags.png).into(countryImage)
    }


}