package com.smartheard.aaratechnologypvtltd.Models


import com.google.gson.annotations.SerializedName

data class AllPropertyResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
) {
    data class Data(
        @SerializedName("date")
        val date: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("latitude")
        val latitude: String,
        @SerializedName("longitude")
        val longitude: String,
        @SerializedName("property_address")
        val propertyAddress: String,
        @SerializedName("property_name")
        val propertyName: String,
        @SerializedName("rating")
        val rating: String
    )
}