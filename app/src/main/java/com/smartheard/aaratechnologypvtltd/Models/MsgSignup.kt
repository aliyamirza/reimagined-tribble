package com.smartheard.aaratechnologypvtltd.Models


import com.google.gson.annotations.SerializedName

data class MsgSignup(
    @SerializedName("email")
    val email: String,
    @SerializedName("mobile")
    val mobile: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String
)