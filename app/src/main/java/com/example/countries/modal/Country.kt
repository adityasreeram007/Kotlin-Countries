package com.example.countries.modal

import com.google.gson.annotations.SerializedName
import kotlin.collections.*;

public data class Country(
//    @SerializedName("name") var name:Map<String,String>,
    @SerializedName("population") var population:Int,
    @SerializedName("latlng") var latlon : Array<Double>

    )
