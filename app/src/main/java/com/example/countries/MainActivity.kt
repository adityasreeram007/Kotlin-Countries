package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countries.dao.DataAccess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dataaccess= DataAccess()
        var retrofit=dataaccess.getBuilder()
    }
}