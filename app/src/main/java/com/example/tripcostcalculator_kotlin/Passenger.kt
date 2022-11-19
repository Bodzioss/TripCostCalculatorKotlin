package com.example.tripcostcalculator_kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Base64.Decoder
@Parcelize
data class Passenger(
    val name: String,
    val distance: Double
):Parcelable