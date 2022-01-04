package com.example.countries.dao

import android.util.Log
import com.example.countries.modal.Country
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.collections.List;
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.io.StringReader
import java.util.ArrayList
import kotlin.reflect.typeOf

class DataAccess {
    lateinit var dataArray:List<Country>;

     fun getBuilder():List<Country>{

        try {
            var url="https://restcountries.com/v3.1/"
//            val okhttpClient = OkHttpClient.Builder();
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
                .build()
//        val retrofit=builder.build()
            Log.d("retro",retrofit.toString())
            val api = retrofit.create(Api::class.java)
            val scope = CoroutineScope(Dispatchers.IO).launch {
                System.out.println("p!")
                val response = api.getCountries()
                System.out.println("p!")
                Log.d("resq", response.toString())
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val gson = GsonBuilder().setPrettyPrinting().create()
                        val responseText =response.body()?.string()

                       val prettyJson=  gson.toJson(
                            JsonParser.parseString(
                                responseText// About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                            )
                        )
//                        Log.d("success", prettyJson)
                        val gsonObject = GsonBuilder().create()
                        println("bodies "+ responseText )
                         dataArray   = gsonObject.fromJson(responseText,Array<Country>::class.java).toList()
                        System.out.println("sizee"+dataArray.size)



                    } else {

                        Log.d("failed", "failed")
                    }
                }
            }

            System.out.println(scope.isCompleted)

        }
        catch(e:Exception ){
            System.out.println(e.toString())
        }
         return dataArray


    }
//    suspend fun getData(){
//
//
//
//
//    }
}

fun main(){



//    val countryRequest=api.getCountries()
//    countryRequest.enqueue( object : Callback<List<Country>> {
//        override fun onResponse(call: retrofit2.Call<List<Country>>, response: Response<List<Country>>) {
//           val countries=response.body()
//            for ( c in countries!!)
//                Log.d(c.name.toString(),c.population.toString())
//
//
//
//
//                   }
//
//        override fun onFailure(call: retrofit2.Call<List<Country>>, t: Throwable) {
//            Log.d("failure","failure")
//        }
//    }

//    )
    System.out.println("!")



    System.out.println()


}