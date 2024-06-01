package com.example.instagram.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.model.local.HightlightDataModel

class HighlightAdapter(var context: Context, var arr:ArrayList<HightlightDataModel>): RecyclerView.Adapter<HighlightAdapter.ViewHolder>() {
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var imgHighLight=view.findViewById<ImageView>(R.id.image_highlight)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rv_highlights,parent,false))
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgHighLight.setImageResource(arr[position].img)
    }
}