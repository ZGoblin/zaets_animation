package com.example.zaetsanimation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.annotation.DrawableRes

@Parcelize
data class Contact (
        val name: String,
        val phone: String,
        @DrawableRes
        val avatar: Int
        ) : Parcelable