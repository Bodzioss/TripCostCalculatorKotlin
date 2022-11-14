package com.example.tripcostcalculator_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PassengerAdapter (
    private val passengers: MutableList<Passenger>, private val passengerClickListener : PassengerClickListener
) : RecyclerView.Adapter<PassengerAdapter.PassengerViewHolder>(){

    class PassengerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val passengerName : TextView = itemView.findViewById(R.id.passengerNameLabel)
        val passengerDistance : TextView = itemView.findViewById(R.id.passengerDistanceLabel)
        val btnDeletePassenger :TextView = itemView.findViewById(R.id.btnDeletePassenger)
    }

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


    override fun onBindViewHolder(holder: PassengerViewHolder, position: Int) {
        val curPassenger = passengers[position]
        holder.itemView.apply {
            holder.passengerName.text = curPassenger.name
            holder.passengerDistance.text = curPassenger.distance.toString()
            holder.btnDeletePassenger.setOnClickListener{
                passengerClickListener.removePassenger(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return passengers.size
    }

}