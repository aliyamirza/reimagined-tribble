package com.smartheard.aaratechnologypvtltd.Models


import com.google.gson.annotations.SerializedName

data class MsgAllPropertyModel(
    @SerializedName("distance")
    val distance: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)