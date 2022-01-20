package com.smartheard.aaratechnologypvtltd

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.smartheard.aaratechnologypvtltd.Models.MsgSignup
import com.smartheard.aaratechnologypvtltd.Utils.ApiResponse
import com.smartheard.aaratechnologypvtltd.ViewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class Signup : AppCompatActivity() {
     private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        login.setOnClickListener {
            startActivity(Intent(this,Signin::class.java))
        }


        buttonSignUp.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val number = editTextNumber.text.toString()
            val password = editTextPassword.text.toString()
            val msgSignup = MsgSignup("$email","$number","$name","$password")
            signup(msgSignup)
        }

    }

    private fun signup(msgSignup: MsgSignup) {

        val progressBar = ProgressDialog(this)
        progressBar.setMessage("Please wait...")
        mainViewModel.signupData(msgSignup)
      lifecycleScope.launchWhenStarted {
          mainViewModel.signupData(msgSignup).collect {
              when(it){
                  is ApiResponse.Failure ->{
                      Log.e("Signup","${it.msg}")
                  progressBar.dismiss()
                  }
                 is ApiResponse.Success ->{
                      Log.e("SignupResponse","${it.data}")
                     progressBar.dismiss()
                 }
                  ApiResponse.Loading ->{
                      progressBar.show()
                  }
              }
          }
      }

    }
}