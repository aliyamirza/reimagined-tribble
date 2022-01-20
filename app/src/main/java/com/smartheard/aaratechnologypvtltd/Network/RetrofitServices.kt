package com.smartheard.aaratechnologypvtltd.Network

import com.smartheard.aaratechnologypvtltd.Models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitServices
{
    companion object {
        const val BASE_URL = "https://review.aaratechnologies.in/api/index.php/"
    }
    @POST("signup")
  suspend  fun signupData(@Body msgSignup: MsgSignup):Response<SignUpResponseModel>

    @POST("login")
    suspend fun loginData(@Body loginMsg:LoginMsgModel):Response<LoginResponseModel>

    @POST("all-property")
    suspend fun allPropertyData(@Body msgAllPropertyModel: MsgAllPropertyModel):Response<AllPropertyResponse>


}