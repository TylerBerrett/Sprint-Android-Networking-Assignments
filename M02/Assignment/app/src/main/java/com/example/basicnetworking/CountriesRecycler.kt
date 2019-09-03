package com.example.basicnetworking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicnetworking.model.OceaniaCountry
import kotlinx.android.synthetic.main.display_countries.view.*

class CountriesRecycler(val list: List<OceaniaCountry>?) : RecyclerView.Adapter<CountriesRecycler.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.display_countries, parent, false)
        return (ViewHolder(view))
    }

    override fun getItemCount(): Int = list!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.country.text = list!![position].name
        holder.population.text = "Population: ${list[position].population}"
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
        val country = item.country_name
        val population = item.country_population

    }

}