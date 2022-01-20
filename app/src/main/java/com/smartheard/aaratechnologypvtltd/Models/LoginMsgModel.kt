package com.smartheard.aaratechnologypvtltd.Models


import com.google.gson.annotations.SerializedName

data class LoginMsgModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)