package com.frieda.temperatureconverter

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<TextInputEditText>(R.id.text_input)
        val celcToFahrRadioButton = findViewById<RadioButton>(R.id.radioButton)
        val fahrToCelcRadioButton = findViewById<RadioButton>(R.id.radioButton2)
        val buttonConvert = findViewById<Button>(R.id.button)

        buttonConvert.setOnClickListener {
            val temp = input.text.toString()
            var sharedPreferences = this.getSharedPreferences("com.frieda.temperatureconverter.result", android.content.Context.MODE_PRIVATE)
            var result = 0.0
            if (celcToFahrRadioButton.isChecked) {
                result = celciusToFahrenheit(temp.toDouble())
            } else if (fahrToCelcRadioButton.isChecked) {
                result = fahrenheitToCelcius(temp.toDouble())
            }
            sharedPreferences.edit().putString("result", result.toString()).apply()
            val intent = Intent(this, ConvertActivity::class.java)
            startActivity(intent)
        }

    }

    private fun celciusToFahrenheit(temp: Double): Double{
        return (temp*9/5)+32
    }

    private fun fahrenheitToCelcius(temp: Double): Double{
        return  ((temp-32)*5/9)
    }
}

