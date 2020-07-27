package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardHeroAdapter(val listHeroes: ArrayList<Hero>): RecyclerView.Adapter<CardHeroAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var name: TextView = itemView.findViewById(R.id.tv_item_name)
        var detail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var favBtn: Button = itemView.findViewById(R.id.favorite)
        var shareBtn: Button = itemView.findViewById(R.id.share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_hero, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listHeroes[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.name.text = listHeroes[position].name
        holder.detail.text = listHeroes[position].detail
        holder.favBtn.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Favorite " + listHeroes[position].name, Toast.LENGTH_SHORT).show()
        }
        holder.shareBtn.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Share " + listHeroes[position].name, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "You chose  " + listHeroes[position].name, Toast.LENGTH_SHORT).show()
        }
    }
}