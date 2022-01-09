package com.example.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.countries.modal.Country
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card.*

class CountryDetail: AppCompatActivity() {
    var tableView:TableLayout?=null
    var country:Country?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countrydetail)
        country=intent.getSerializableExtra("countrydata") as? Country
        println("count"+country)
        val imageView:ImageView=findViewById(R.id.backimage)
        Picasso.get().load(country?.flags?.pngFlag).into(imageView)
         tableView=findViewById(R.id.tableview)
        val name=country?.component3()
        getTableRow("Name",name?.common)
        getTableRow("Official",name?.official)
        val population=country?.component1()
        getTableRow("Population",population.toString())
        val area=country?.component12()
        getTableRow("Area",area.toString())
        val latlon=country?.component2()
        getTableRow("Latitude",latlon?.get(0).toString())
        getTableRow("Longitude",latlon?.get(1).toString())
        val borderProtected=country?.component8()
        getTableRow("Bordered",borderProtected)
        val timeZones=country?.component9()
        getTableRow("Time Zones",timeZones?.joinToString(","))
        val capital=country?.component6()
        getTableRow("Capital",capital?.joinToString(","))
        val continent=country?.component7()
        getTableRow("Continents",continent?.joinToString(","))
        val unmember=country?.component4()
        getTableRow("UN member",unmember)
        val independent=country?.component5()
        getTableRow("Independent",independent)
        val startOfWeek=country?.component11()
        getTableRow("StartOfWeek",startOfWeek)
        tableView?.requestLayout()

    }
    fun getTableRow( key:String, value:String?){
        val tableRow= LayoutInflater.from(this.applicationContext).inflate(R.layout.listcard,tableView,false)



        val textView1:TextView= tableRow.findViewById(R.id.col1)
        textView1.setText(key)
        val textView2:TextView= tableRow.findViewById(R.id.col2)
        textView2.setText(value)
        tableView?.addView(tableRow)

    }




}