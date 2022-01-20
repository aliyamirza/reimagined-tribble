package com.smartheard.aaratechnologypvtltd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.smartheard.aaratechnologypvtltd.Models.AllPropertyResponse
import com.smartheard.aaratechnologypvtltd.Models.MsgAllPropertyModel

class MainAdapter (var list: AllPropertyResponse): RecyclerView.Adapter<MainAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.itemView.apply {
            Toast.makeText(context, "${list.data[position].id}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return list.data.size
    }

}