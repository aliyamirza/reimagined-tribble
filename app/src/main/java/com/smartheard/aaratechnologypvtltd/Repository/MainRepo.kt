package com.smartheard.aaratechnologypvtltd.Repository

import com.smartheard.aaratechnologypvtltd.Models.LoginMsgModel
import com.smartheard.aaratechnologypvtltd.Models.MsgAllPropertyModel
import com.smartheard.aaratechnologypvtltd.Models.MsgSignup
import com.smartheard.aaratechnologypvtltd.Network.RetrofitServices
import com.smartheard.aaratechnologypvtltd.Utils.result
import javax.inject.Inject

class MainRepo @Inject constructor(val retrofitServices: RetrofitServices){

    fun signupData(msgSignup: MsgSignup) =
        result {
            retrofitServices.signupData(msgSignup)
        }

    fun loginData(msgLoginMsgModel: LoginMsgModel) =
        result {
            retrofitServices.loginData(msgLoginMsgModel)
        }

    fun getHomeData(msgAllPropertyModel: MsgAllPropertyModel) = result {
        retrofitServices.allPropertyData(msgAllPropertyModel)
    }

}