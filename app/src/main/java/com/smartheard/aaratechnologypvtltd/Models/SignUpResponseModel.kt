package com.smartheard.aaratechnologypvtltd.Models


import com.google.gson.annotations.SerializedName

data class SignUpResponseModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)