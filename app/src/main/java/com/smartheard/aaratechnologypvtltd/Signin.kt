package com.smartheard.aaratechnologypvtltd

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.smartheard.aaratechnologypvtltd.Models.LoginMsgModel
import com.smartheard.aaratechnologypvtltd.Utils.ApiResponse
import com.smartheard.aaratechnologypvtltd.ViewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class Signin : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        register.setOnClickListener {
            startActivity(Intent(this,Signup::class.java))
        }


        buttonLogin.setOnClickListener {
            val emailLogin = editLoginEmail.text.toString()
            val passwordLogin = editLoginPassword.text.toString()
            val msgLoginMsgModel = LoginMsgModel("${emailLogin}", "${passwordLogin}")
            login(msgLoginMsgModel)
        }

    }

    private fun login(msgLoginMsgModel: LoginMsgModel) {

        val progressBar = ProgressDialog(this)
        progressBar.setMessage("Please wait...")

        lifecycleScope.launchWhenStarted {
            mainViewModel.loginData(msgLoginMsgModel).collect {
                when (it) {
                    is ApiResponse.Failure -> {
                    Log.e("Signin","${it.msg}")
                        progressBar.dismiss()
                    }
                    is ApiResponse.Success -> {
                        Log.e("Signinesponse", "${it.data}")
                        if (it.data?.status ==404) {
                            startActivity(Intent(this@Signin, Home::class.java))
                        }
                        progressBar.dismiss()
                    }
                    ApiResponse.Loading -> {
                        progressBar.show()
                    }
                }
            }
        }
    }
}