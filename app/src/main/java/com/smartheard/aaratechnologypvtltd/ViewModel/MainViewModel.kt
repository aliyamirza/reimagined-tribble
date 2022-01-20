package com.smartheard.aaratechnologypvtltd.ViewModel

import androidx.lifecycle.ViewModel
import com.smartheard.aaratechnologypvtltd.Models.LoginMsgModel
import com.smartheard.aaratechnologypvtltd.Models.MsgAllPropertyModel
import com.smartheard.aaratechnologypvtltd.Models.MsgSignup
import com.smartheard.aaratechnologypvtltd.Repository.MainRepo
import com.smartheard.aaratechnologypvtltd.Utils.result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepo: MainRepo): ViewModel() {

    fun signupData(msgSignup: MsgSignup)=
        mainRepo.signupData(msgSignup)

    fun loginData(msgLoginMsgModel: LoginMsgModel)=
        mainRepo.loginData(msgLoginMsgModel)

    fun getHomeData(msgAllPropertyModel: MsgAllPropertyModel) =
        mainRepo.getHomeData(msgAllPropertyModel)

}