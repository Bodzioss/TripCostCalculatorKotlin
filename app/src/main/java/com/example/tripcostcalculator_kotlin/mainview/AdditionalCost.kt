package com.example.tripcostcalculator_kotlin.mainview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AdditionalCost (
    val name: String,
    val price: Double
): Parcelable