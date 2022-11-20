package com.example.tripcostcalculator_kotlin.resultview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.tripcostcalculator_kotlin.R
import com.example.tripcostcalculator_kotlin.mainview.AdditionalCost
import com.example.tripcostcalculator_kotlin.mainview.MainActivity
import com.example.tripcostcalculator_kotlin.mainview.Passenger
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.fuelCostCardLabel
import kotlinx.android.synthetic.main.passenger_card_view.*


class ResultActivity : AppCompatActivity() {
    private var listView: ListView ? =null
    private var passengerAdapters:PassengersResultListAdapters ? =null
    private var arrayListPassengers:ArrayList<Passenger> ? =null
    private var arrayListCosts:ArrayList<AdditionalCost> ? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        fuelCostCardLabel.text = intent.getStringExtra("sumFuelCost")
        additionalCostSumLabel.text = intent.getStringExtra("sumAdditionalCosts")
        btnOpenMainView.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        listView = findViewById(R.id.passengerListView)
        arrayListPassengers = intent.getParcelableArrayListExtra("passengers")
        arrayListCosts = intent.getParcelableArrayListExtra("additionalCosts")
        passengerAdapters = PassengersResultListAdapters(applicationContext,arrayListPassengers!!,arrayListCosts!!)
        listView?.adapter = passengerAdapters


        setListViewHeightBasedOnChildren(passengerListView)


    }

    fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter: ListAdapter = listView.getAdapter()
            ?: // pre-condition
            return
        var totalHeight = 0

        for (i in 0 until listAdapter.getCount()) {
            val listItem: View = listAdapter.getView(i, null, listView)
            listItem.measure(0, 0)
            totalHeight += listItem.getMeasuredHeight()
        }
        val params: ViewGroup.LayoutParams = listView.getLayoutParams()
        params.height = totalHeight + listView.getDividerHeight() * (listAdapter.getCount() - 1)
        listView.setLayoutParams(params)
        listView.requestLayout()
    }
}