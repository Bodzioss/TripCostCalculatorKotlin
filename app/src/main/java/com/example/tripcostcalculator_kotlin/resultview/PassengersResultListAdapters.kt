package com.example.tripcostcalculator_kotlin.resultview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import com.example.tripcostcalculator_kotlin.R
import com.example.tripcostcalculator_kotlin.mainview.AdditionalCost
import com.example.tripcostcalculator_kotlin.mainview.Passenger

class PassengersResultListAdapters(var context: Context, var passengers: ArrayList<Passenger>,var additionalCost: ArrayList<AdditionalCost>): BaseAdapter() {
    private var listView: ListView? =null
    private var additionalCostAdapters:AdditionalCostListAdapter ? =null
    private var arrayList:ArrayList<AdditionalCost> ? =null

    override fun getCount(): Int {
        return passengers.size
    }

    override fun getItem(position: Int): Any {
        return passengers.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = View.inflate(context, R.layout.passenger_card_view,null)

        val passengerName:TextView = view.findViewById(R.id.passengerNameCardLabel)

        val fuelPrice:TextView = view.findViewById(R.id.fuelCostCardLabel)

        val additionalCost:TextView = view.findViewById(R.id.additionalCostCardLabel)

        val sumPrice:TextView = view.findViewById(R.id.passengerCostCardLabel)

        var passenger:Passenger = passengers.get(position)

        passengerName.text = passenger.name

        fuelPrice.text = passenger.fuelCost.toString() + " zł"

        additionalCost.text = passenger.additionalCost.toString() + " zł"

        sumPrice.text = (passenger.fuelCost + passenger.additionalCost).toString() + "zł"

        return view!!
    }

}