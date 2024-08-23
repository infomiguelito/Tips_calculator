package com.example.tips_calculator

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
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rbOptionsOne.setOnCheckedChangeListener { _, isCheked ->
            println("miguel one $isCheked")
            if (isCheked) {
                percentage = 10
            }
        }

        binding.rbOptionsTwo.setOnCheckedChangeListener { _, isCheked ->
            println("miguel two $isCheked")
            if (isCheked) {
                percentage = 15
            }
        }

        binding.rbOptionsThree.setOnCheckedChangeListener { _, isCheked ->
            println("miguel three $isCheked")
            if (isCheked) {
                percentage = 20
            }
        }
        var numbOfPeopleSelect = 0
        binding.spinerPeople.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                numbOfPeopleSelect = p2

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.numpeople,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinerPeople.adapter = adapter


        binding.btnCalculator.setOnClickListener {


            val totalTemp = binding.tieTotal.text

            if (totalTemp?.isEmpty() == true) {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val total: Float = totalTemp.toString().toFloat()
                val people: Int = numbOfPeopleSelect

                val Temp = total / people
                val tips = Temp * percentage / 100
                val totaltips = Temp + tips
                binding.tvResult.text = "Total: $totaltips"
            }


        }


        binding.btnClean.setOnClickListener {

            binding.tvResult.text = ""
            binding.tieTotal.setText("")
            binding.rbOptionsOne.isChecked = false
            binding.rbOptionsTwo.isChecked = false
            binding.rbOptionsThree.isChecked = false
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}



