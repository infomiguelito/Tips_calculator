package com.example.tips_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        val total = intent.getFloatExtra("total",0f)
        val people = intent.getIntExtra("people", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totaltips = intent.getFloatExtra("totaltips",0f)
    }
}