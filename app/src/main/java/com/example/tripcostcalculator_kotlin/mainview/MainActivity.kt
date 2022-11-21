package com.example.tripcostcalculator_kotlin.mainview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tripcostcalculator_kotlin.R
import com.example.tripcostcalculator_kotlin.resultview.ResultActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PassengerClickListener, AdditionalCostClickListener {

    private lateinit var passengerAdapter: PassengerAdapter
    private lateinit var additionalCostAdapter: AdditionalCostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        passengerAdapter = PassengerAdapter(mutableListOf(),this@MainActivity)
        additionalCostAdapter = AdditionalCostAdapter(mutableListOf(),this@MainActivity)

        passengerItems.adapter = passengerAdapter
        passengerItems.layoutManager = LinearLayoutManager(this)
        btnAddPassenger.setOnClickListener{
            val passengerName = passengerNameInput.text.toString()
            val passengerDistance = passengerDistanceInput.text.toString()
            if(passengerName.isNotEmpty() && passengerDistance.isNotEmpty())
            {
                val passenger = Passenger(passengerName,passengerDistance.toDouble(),0.0,0.0)
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

        btnOpenMainView.setOnClickListener{
            val combustion = combustionInput.text.toString().toDouble()
            val fuelCost = fuelCostInput.text.toString().toDouble()
            val sumFuelCost: String = passengerAdapter.sumFuelCost(fuelCost,combustion)
            val additionalCostPrice: String = additionalCostAdapter.sumAdditionalCosts()
            passengerAdapter.calculatePassengers(combustion, fuelCost, additionalCostAdapter.getAdditionalCosts())

            val intent = Intent(this, ResultActivity::class.java)
            val sumCosts:Double = sumFuelCost.toDouble()+additionalCostPrice.toDouble()
            intent.putExtra("sumFuelCost",sumFuelCost + "zł")
            intent.putExtra("sumAdditionalCosts",additionalCostPrice + "zł")
            intent.putExtra("sumCosts",sumCosts.toString() + "zł")
            intent.putParcelableArrayListExtra("passengers",ArrayList(passengerAdapter.getPassengers()))
            intent.putParcelableArrayListExtra("additionalCosts",ArrayList(additionalCostAdapter.getAdditionalCosts()))
            fuelCostUnit.text = sumFuelCost
            startActivity(intent)
        }
    }

    override fun removePassenger(position: Int) {
        passengerAdapter.removePassenger(position)
    }


    override fun removeAdditionalCost(position: Int) {
        additionalCostAdapter.removeAdditionalCost(position)
    }

}