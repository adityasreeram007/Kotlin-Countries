package com.example.countries.dao

import retrofit2.http.GET
import com.example.countries.modal.Country
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Path


interface Api  {
@GET("all")
  suspend fun getCountries(): Response<ResponseBody>;
}