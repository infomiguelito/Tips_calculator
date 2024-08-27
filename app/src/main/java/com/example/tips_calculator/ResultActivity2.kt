package com.example.tips_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tips_calculator.databinding.ActivityResult2Binding

class ResultActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityResult2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResult2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val total = intent.getFloatExtra("total",0f)
        val people = intent.getIntExtra("people", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totaltips = intent.getFloatExtra("totaltips",0f)

        binding.tvPercentage.text = percentage.toString() + "%"
        binding.tvTotalConta.text = total.toString()
        binding.tvPeople.text = people.toString()
        binding.tvTotal.text = totaltips.toString()

        binding.btnVoltar.setOnClickListener {
            finish()
        }

    }
}