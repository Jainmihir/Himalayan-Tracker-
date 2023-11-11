package com.example.himalayantracker.ui

import android.animation.LayoutTransition
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.himalayantracker.R


class hotelsadapter(val context : Context , val itemList: ArrayList<String>) : RecyclerView.Adapter<hotelsadapter.HotelsViewHolder>(){
    class HotelsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.row_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.recycler_hotels_single_row,parent,false)
        return HotelsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        val text =  itemList[position]
        holder.textView.text =text
    }

}