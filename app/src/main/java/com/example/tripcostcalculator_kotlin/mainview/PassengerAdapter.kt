package com.example.tripcostcalculator_kotlin.mainview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tripcostcalculator_kotlin.R
import kotlinx.android.synthetic.main.passenger_item.view.*
import java.math.BigDecimal
import java.math.RoundingMode


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

    fun calculatePassengerFuelCost(passenger: Passenger,fuelCost: Double, combustion: Double): Double {
        var passengerFuelCost = combustion / 100 * fuelCost * passenger.distance
        return passengerFuelCost
    }

    fun calculatePassengerAdditionalCost(additionalCosts:MutableCollection<AdditionalCost>?,passengerCount:Int): Double {
        var sumAdditionalCost:Double = 0.0
        if (additionalCosts != null) {
            additionalCosts.forEach{
                sumAdditionalCost += it.price / passengerCount
            }
        }
        return BigDecimal(sumAdditionalCost).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    }

    fun calculatePassengers(combustion: Double, fuelCost: Double, additionalCosts:MutableCollection<AdditionalCost>?){
        passengers.forEach{
            it.fuelCost = BigDecimal(calculatePassengerFuelCost(it,fuelCost,combustion)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
            it.additionalCost = BigDecimal(calculatePassengerAdditionalCost(additionalCosts,passengers.size)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        }
    }

    fun sumFuelCost(fuelCost: Double,combustion: Double): String {
        var sumFuelCost: Double = 0.0
        val costForKm:Double = combustion / 100 * fuelCost
        passengers.forEach{
            sumFuelCost += it.distance * costForKm
        }
        return BigDecimal(sumFuelCost).setScale(2, RoundingMode.HALF_EVEN).toString()
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