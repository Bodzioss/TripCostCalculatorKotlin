package com.example.tripcostcalculator_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.passenger_item.*

class MainActivity : AppCompatActivity() {

    private lateinit var passengerAdapter: PassengerAdapter
    private lateinit var additionalCostAdapter: AdditionalCostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        passengerAdapter = PassengerAdapter(mutableListOf())
        additionalCostAdapter = AdditionalCostAdapter(mutableListOf())

        passengerItems.adapter = passengerAdapter
        passengerItems.layoutManager = LinearLayoutManager(this)

        btnAddPassenger.setOnClickListener{
            val passengerName = passengerNameInput.text.toString()
            val passengerDistance = passengerDistanceInput.text.toString()
            if(passengerName.isNotEmpty() && passengerDistance.isNotEmpty())
            {
                val passenger = Passenger(passengerName,passengerDistance.toDouble())
                passengerAdapter.addPassenger(passenger)
            }
        }

        additionalCostItems.adapter = additionalCostAdapter
        additionalCostItems.layoutManager = LinearLayoutManager(this)

        btnAddAdditionalCost.setOnClickListener {
            val additionalCostName = additionalCostNameInput.text.toString()
            val additionalCostPrice = additionalCostPriceInput.text.toString()

            if (additionalCostName.isNotEmpty() && additionalCostPrice.isNotEmpty()) {
                val additionalCost =
                    AdditionalCost(additionalCostName, additionalCostPrice.toDouble())
                additionalCostAdapter.addAdditionalCost(additionalCost)
            }

        }


    }
}