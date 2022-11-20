package com.example.tripcostcalculator_kotlin.resultview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import com.example.tripcostcalculator_kotlin.R
import com.example.tripcostcalculator_kotlin.mainview.Passenger

class PassengersResultListAdapters(var context: Context, var passengers: ArrayList<Passenger>): BaseAdapter() {
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

        val name:TextView = view.findViewById(R.id.passengerNameCardLabel)

        var passenger:Passenger = passengers.get(position)

        name.text = passenger.name

        return view!!
    }

}