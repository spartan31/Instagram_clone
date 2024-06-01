package com.example.instagram.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.model.local.HightlightDataModel

class UserProfileGridAdapter(
    private val context: Context, private val arr: ArrayList<HightlightDataModel>
) : RecyclerView.Adapter<UserProfileGridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_rv_userprofile_grid, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = arr[position]
        holder.bind(dataModel)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgHighLight: ImageView = itemView.findViewById(R.id.image_highlight)

        fun bind(dataModel: HightlightDataModel) {
            imgHighLight.setImageResource(dataModel.img)
        }
    }
}


