package com.example.tripcostcalculator_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.additionalcost_item.view.*
import kotlinx.android.synthetic.main.passenger_item.view.*

class AdditionalCostAdapter (private val additionalCosts : MutableList<AdditionalCost>
): RecyclerView.Adapter<AdditionalCostAdapter.AdditionalCostViewHolder>(){

    class AdditionalCostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    fun addAdditionalCost(additionalCost: AdditionalCost){
        additionalCosts.add(additionalCost)
        notifyItemInserted(additionalCosts.size-1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdditionalCostViewHolder {
        return AdditionalCostAdapter.AdditionalCostViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.additionalcost_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdditionalCostViewHolder, position: Int) {
        val curAdditionalCost = additionalCosts[position]
        holder.itemView.apply {
            holder.itemView.additionalCostNameLabel.text = curAdditionalCost.name
            holder.itemView.additionalCostPriceLabel.text = curAdditionalCost.price.toString()
        }
    }

    override fun getItemCount(): Int {
        return additionalCosts.size
    }
}