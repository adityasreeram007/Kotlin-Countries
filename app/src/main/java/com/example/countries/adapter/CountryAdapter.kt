package com.example.countries.adapter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R

import com.example.countries.modal.Country

class CountryAdapter(val countryList:List<Country>?  ):RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country= countryList?.get(position)
        if (country != null) {
            holder.imageView.setImageURI(Uri.parse(country.flags.pngFlag))
            holder.textView.text=country.name.common
        }

    }

    override fun getItemCount(): Int {
        if(countryList!=null)
        return countryList.size
        return 0
    }

    class ViewHolder(CountryView: View):RecyclerView.ViewHolder(CountryView){
        val imageView:ImageView=CountryView.findViewById(R.id.img);
        val textView:TextView=CountryView.findViewById(R.id.country_name)




    }
}