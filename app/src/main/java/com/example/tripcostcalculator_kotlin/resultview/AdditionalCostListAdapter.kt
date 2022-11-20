package com.example.tripcostcalculator_kotlin.resultview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tripcostcalculator_kotlin.R
import com.example.tripcostcalculator_kotlin.mainview.AdditionalCost

class AdditionalCostListAdapter(var context: Context, var additionalCosts: ArrayList<AdditionalCost>): BaseAdapter() {
    override fun getCount(): Int {
        return additionalCosts.size
    }

    override fun getItem(position: Int): Any {
        return additionalCosts.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.additionalcost_card_view,null)

        val name: TextView = view.findViewById(R.id.additionalCostNameLabel)

        val price: TextView = view.findViewById(R.id.additionalCostNameLabel)

        var additionalCost: AdditionalCost = additionalCosts.get(position)

        name.text = additionalCost.name
        price.text = additionalCost.price.toString()

        return view!!
    }

}