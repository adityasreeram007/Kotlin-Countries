package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.adapter.CountryAdapter
import com.example.countries.dao.DataAccess
import com.example.countries.modal.Country
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
        var countryList:List<Country>?=null;
    var recyclerView:RecyclerView?=null;
    var adapter:RecyclerView.Adapter<*>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView?.layoutManager=LinearLayoutManager(this)
        var dataaccess= DataAccess()
        GlobalScope.launch {
        countryList=dataaccess.getBuilder()
            println("list "+ countryList?.get(0))
            adapter=CountryAdapter(countryList)
            recyclerView?.adapter =adapter
        }

    }
}