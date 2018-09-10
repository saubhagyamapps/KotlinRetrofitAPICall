package com.example.android.kotlinretrofitapicall.adepter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.kotlinretrofitapicall.R
import com.example.android.kotlinretrofitapicall.model.ResponceModel
import kotlinx.android.synthetic.main.inflate_list.view.*

class MyAdepter(var context: Context, var list: List<ResponceModel.Data>) : RecyclerView.Adapter<MyAdepter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.inflate_list, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = list.get(position).quotes_name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvName

    }
}