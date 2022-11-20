package com.example.tripcostcalculator_kotlin.mainview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tripcostcalculator_kotlin.R
import kotlinx.android.synthetic.main.passenger_item.view.*


class PassengerAdapter (
    private val passengers: MutableList<Passenger>, private val passengerClickListener : PassengerClickListener
) : RecyclerView.Adapter<PassengerAdapter.PassengerViewHolder>(){

    class PassengerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassengerViewHolder {
        return PassengerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.passenger_item,
                parent,
                false
            )
        )
    }

    fun addPassenger(passenger: Passenger){
        passengers.add(passenger)
        notifyItemInserted(passengers.size-1)
    }

    fun removePassenger(position: Int){
        passengers.removeAt(position)
        notifyItemRemoved(passengers.size-1)
    }

    fun getPassengers(): MutableList<Passenger> {
        return passengers
    }

    fun sumFuelCost(fuelCost: Double,combustion: Double): String {
        var sumFuelCost: Double = 0.0
        val costForKm:Double = combustion / 100 * fuelCost
        passengers.forEach{
            sumFuelCost += it.distance * costForKm
        }
        return sumFuelCost.toString() + "zł"
    }


    override fun onBindViewHolder(holder: PassengerViewHolder, position: Int) {
        val curPassenger = passengers[position]
        holder.itemView.apply {
            holder.itemView.passengerNameLabel.text = curPassenger.name
            holder.itemView.passengerDistanceLabel.text = curPassenger.distance.toString()
            holder.itemView.btnDeletePassenger.setOnClickListener{
                passengerClickListener.removePassenger(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return passengers.size
    }

}