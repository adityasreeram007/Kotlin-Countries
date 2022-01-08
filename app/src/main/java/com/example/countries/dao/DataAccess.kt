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


    suspend fun getBuilder():List<Country>?{
        var dataArray:List<Country>?=null;

            var url="https://restcountries.com/v3.1/"
            val retrofit = Retrofit.Builder()
                .baseUrl(url)

                .build()
            Log.d("retro",retrofit.toString())
            val api = retrofit.create(Api::class.java)
//            val scope = CoroutineScope(Dispatchers.IO).launch {

                System.out.println("p!")
                val response = api.getCountries()
                System.out.println("p!")
                Log.d("resq", response.toString())

                    if (response.isSuccessful) {
                        val gson = GsonBuilder().setPrettyPrinting().create()
                        val responseText =response.body()?.string()

                       val prettyJson=  gson.toJson(
                            JsonParser.parseString(
                                responseText
                            )
                        )

                        val gsonObject = GsonBuilder().create()
                        println("bodies "+ responseText )
                         dataArray   = gsonObject.fromJson(responseText,Array<Country>::class.java).toList()
                        System.out.println("sizee"+dataArray?.size)

                    } else {

                        Log.d("failed", "failed")
                    }


//            }

//            System.out.println(scope.isCompleted)


         return dataArray


    }

}

fun main(){

    System.out.println("!")



    System.out.println()


}