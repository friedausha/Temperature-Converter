package com.frieda.temperatureconverter

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ConvertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)

        val sharedPreferences = this.getSharedPreferences("com.frieda.temperatureconverter.result", android.content.Context.MODE_PRIVATE)
        val text = findViewById<TextView>(R.id.textView2)
        text.text = sharedPreferences.getString("result", "").toString()
    }
}
