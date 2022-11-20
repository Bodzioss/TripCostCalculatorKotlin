package com.example.tripcostcalculator_kotlin.mainview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tripcostcalculator_kotlin.R
import kotlinx.android.synthetic.main.additionalcost_item.view.*

class AdditionalCostAdapter (private val additionalCosts : MutableList<AdditionalCost>,
                             private val additionalCostClickListener : AdditionalCostClickListener
): RecyclerView.Adapter<AdditionalCostAdapter.AdditionalCostViewHolder>(){

    class AdditionalCostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    fun addAdditionalCost(additionalCost: AdditionalCost){
        additionalCosts.add(additionalCost)
        notifyItemInserted(additionalCosts.size-1)
    }

    fun removeAdditionalCost(position: Int){
        additionalCosts.removeAt(position)
        notifyItemRemoved(additionalCosts.size-1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdditionalCostViewHolder {
        return AdditionalCostViewHolder(
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
            holder.itemView.btnDeleteAdditionalCost.setOnClickListener{
                additionalCostClickListener.removeAdditionalCost(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return additionalCosts.size
    }

    fun sumAdditionalCosts(): String {
        var additionalCostPrice: Double = 0.0
        additionalCosts.forEach{
            additionalCostPrice += it.price
        }
        return additionalCostPrice.toString() + "zł"
    }

    fun  getAdditionalCosts(): MutableCollection<AdditionalCost>? {
        return additionalCosts
    }
}