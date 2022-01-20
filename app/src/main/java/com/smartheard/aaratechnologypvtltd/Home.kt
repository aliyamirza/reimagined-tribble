package com.smartheard.aaratechnologypvtltd

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartheard.aaratechnologypvtltd.Models.MsgAllPropertyModel
import com.smartheard.aaratechnologypvtltd.Utils.ApiResponse
import com.smartheard.aaratechnologypvtltd.ViewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class Home : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val msgAllPropertyModel = MsgAllPropertyModel("50","26.894126999999997","80.964057")
        getAllHomeData(msgAllPropertyModel)
    }

    private fun getAllHomeData(msgAllPropertyModel: MsgAllPropertyModel) {

        lifecycleScope.launchWhenStarted {
            mainViewModel.getHomeData(msgAllPropertyModel).collect {
                when(it){
                    is ApiResponse.Failure -> {
                        Log.e("Home","${it.msg}")
                    }
                    ApiResponse.Loading -> {

                    }
                    is ApiResponse.Success ->{
                        Toast.makeText(this@Home, "${it.data}", Toast.LENGTH_SHORT).show()
//                        val homeAdapter = MainAdapter(it.data!!)
//                        mainRecycler.layoutManager = LinearLayoutManager(this@Home)
//                        mainRecycler.adapter = homeAdapter


                    }
                }
            }
        }

    }
}