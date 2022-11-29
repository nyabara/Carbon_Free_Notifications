package com.example.carbon_free_notifications.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarbonFree(
    val id: Int,
    val carbonFreeName: String,
    val carbonFreeLottie: Int
) : Parcelable