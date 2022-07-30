package com.binar.challenge3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Person(
    val name: String,
    val age: Int?=null,
    val height: Double?=null,
    val weight: Double?=null,
    val gender: String?=null,
): Parcelable
