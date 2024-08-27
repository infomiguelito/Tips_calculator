package com.example.tips_calculator

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tips_calculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnCalculator.setOnClickListener()
        {


            val totalTemp = binding.tieTotal.text
            val numbOfPeopletemp = binding.tiePeopleLabel.text
            val percentage_temp = binding.tiePercentageLabel.text

            if (totalTemp?.isEmpty() == true ||
                numbOfPeopletemp?.isEmpty() == true ||
                percentage_temp?.isEmpty() == true ) {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val total: Float = totalTemp.toString().toFloat()
                val people: Int = numbOfPeopletemp.toString().toInt()
                val percentage : Int = percentage_temp.toString().toInt()
                val Temp = total / people
                val tips = Temp *  percentage / 100
                val totaltips = Temp + tips

                val intent = Intent(this, ResultActivity2::class.java)
                intent.apply {
                    putExtra("total", total)
                    putExtra("people", people)
                    putExtra("percentage", percentage)
                    putExtra("totaltips", totaltips)
                }
                clean()
                startActivity(intent)

            }


        }


        binding.btnClean.setOnClickListener()
        {
            clean()
        }

    }

    private fun clean() {
        binding.tieTotal.setText("")
        binding.tiePeopleLabel.setText("")
        binding.tiePercentageLabel.setText("")


    }
}









