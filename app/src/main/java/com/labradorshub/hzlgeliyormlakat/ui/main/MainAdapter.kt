package com.labradorshub.hzlgeliyormlakat.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.labradorshub.hzlgeliyormlakat.R
import com.labradorshub.hzlgeliyormlakat.model.api.responses.Product
import com.labradorshub.hzlgeliyormlakat.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.maingridlist.view.*

class MainAdapter(val list: List<Product>?) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.maincardtitle)
        var image = itemView.findViewById<ImageView>(R.id.maincardimage)
        var price = itemView.findViewById<TextView>(R.id.maincardprice)
        var layout = itemView.findViewById<LinearLayout>(R.id.mainlayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.maingridlist,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        var context = holder.itemView.context
        holder.title.setText(list?.get(position)?.title)
        holder.price.setText(list?.get(position)?.price.toString()+" TL")
        Glide.with(context).load(list?.get(position)?.image).into(holder.image)
        holder.layout.setOnClickListener {
            var intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("product",list?.get(position))
            context.startActivity(intent)
        }
    }


}