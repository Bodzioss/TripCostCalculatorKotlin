package com.example.tripcostcalculator_kotlin.resultview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tripcostcalculator_kotlin.R
import com.example.tripcostcalculator_kotlin.mainview.MainActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        sumFuelCostLabel.text = intent.getStringExtra("sumFuelCost")
        btnOpenMainView.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}