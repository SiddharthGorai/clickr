package com.example.clickr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class myAdapter(
    private val imgList: ArrayList<imgData>,
    private val context: imagesView
) : RecyclerView.Adapter<myAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)


    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(imgList[position].url).into(holder.img)
        holder.imgTitle.text = imgList[position].title

    }

    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val imgTitle: TextView = itemView.findViewById(R.id.title)
        val img: ImageView = itemView.findViewById(R.id.img)


        }
    }
