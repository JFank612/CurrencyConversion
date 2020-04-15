package com.example.currencyconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val convertNum = findViewById<EditText>(R.id.idUserInput)
        val convertButton = findViewById<Button>(R.id.idConvertBttn)
        val displayResult = findViewById<TextView>(R.id.idResult)
        val dollar = findViewById<RadioButton>(R.id.idEuroToDollarBttn)
        val euro = findViewById<RadioButton>(R.id.idDollarsToEurosBttn)

        convertButton.setOnClickListener {
            val currencyFormat = DecimalFormat("###,###,###.00")
            val dblMeasure = convertNum.text.toString().toDouble()
            val conversion = 0.91
            var convertMeasureNum: Double?

            if (euro.isChecked) {
                if (dblMeasure <= 10000) {
                    convertMeasureNum = dblMeasure * conversion
                    displayResult.text = currencyFormat.format(convertMeasureNum) + "€"
                } else {
                    Toast.makeText(this@MainActivity,"Value must be less than $10,000" , Toast.LENGTH_LONG).show()
                }
            }
            if (dollar.isChecked) {
                if (dblMeasure <= 9143.75) {
                    convertMeasureNum = dblMeasure / conversion
                    displayResult.text = currencyFormat.format(convertMeasureNum) + "$"
                } else {
                    Toast.makeText(this@MainActivity, "Value must be less than 9143.75€", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
