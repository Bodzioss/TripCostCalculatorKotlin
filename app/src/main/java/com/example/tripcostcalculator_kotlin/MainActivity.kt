package com.example.tripcostcalculator_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PassengerClickListener, AdditionalCostClickListener {

    private lateinit var passengerAdapter: PassengerAdapter
    private lateinit var additionalCostAdapter: AdditionalCostAdapter
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        var items: ArrayList<String> = arrayListOf()
        items.add("Apple")
        items.add("Apple")
        items.add("Apple")
        items.add("Apple")

        adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,items)

}

    override fun removePassenger(position: Int) {
        TODO("Not yet implemented")
    }

    override fun removeAdditionalCost(position: Int) {
        TODO("Not yet implemented")
    }
}