package com.example.myproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pirate (
    val name: String,
    val description: String,
    val photo: Int
): Parcelable