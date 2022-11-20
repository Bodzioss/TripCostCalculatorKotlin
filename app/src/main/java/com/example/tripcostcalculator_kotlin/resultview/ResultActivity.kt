package com.example.tripcostcalculator_kotlin.resultview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.tripcostcalculator_kotlin.R
import com.example.tripcostcalculator_kotlin.mainview.MainActivity
import com.example.tripcostcalculator_kotlin.mainview.Passenger
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private var listView: ListView ? =null
    private var passengerAdapters:PassengersResultListAdapters ? =null
    private var arrayList:ArrayList<Passenger> ? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        fuelCostCardLabel.text = intent.getStringExtra("sumFuelCost")
        btnOpenMainView.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        listView = findViewById(R.id.passengerListView)
        arrayList = intent.getParcelableArrayListExtra("passengers")
        passengerAdapters = PassengersResultListAdapters(applicationContext,arrayList!!)
        listView?.adapter = passengerAdapters

    }
}