package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.adapter.CountryAdapter
import com.example.countries.dao.DataAccess
import com.example.countries.modal.Country
import kotlinx.coroutines.*
import java.util.*

class MainActivity : AppCompatActivity() {
        var countryList:List<Country>?=null;
    var recyclerView:RecyclerView?=null;
    var adapter:RecyclerView.Adapter<*>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)
        var dataaccess= DataAccess()
        runBlocking {
           val scope= async {


                 dataaccess.getBuilder()

            }
            countryList=scope.await()



        }
        println("list " + countryList?.get(0))
        adapter = CountryAdapter(countryList)
        recyclerView?.layoutManager=LinearLayoutManager(this)
        recyclerView?.adapter = adapter
        println("one")

    }
}