package com.example.countries

import android.os.Bundle
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import androidx.appcompat.app.AppCompatActivity
import com.example.countries.modal.Country
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card.*

class CountryDetail: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countrydetail)
        val country=intent.getSerializableExtra("countrydata") as? Country
        println("count"+country)
        val imageView:ImageView=findViewById(R.id.backimage)
        Picasso.get().load(country?.flags?.pngFlag).into(imageView)
        val tableView:TableLayout=findViewById(R.id.tableview)

    }




}