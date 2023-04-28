package com.example.musicplayer2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MusicAdapter( val musicList: List<Image>) :
    RecyclerView.Adapter<MusicViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_items, parent, false)
        return MusicViewHolder(view)
    }


    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {

        val currentItem = musicList[position]

        holder.title.text = currentItem.width.toString()
        holder.authors.text = currentItem.height.toString()
//
        Picasso.get().load(currentItem.url).into(holder.image)

    }

    override fun getItemCount(): Int {

        return musicList.size
    }


}


class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView
    val authors: TextView
    val image: ShapeableImageView
    val ratingBar: RatingBar

    init {
        title = itemView.findViewById(R.id.songName)
        image = itemView.findViewById(R.id.productImage)
        ratingBar = itemView.findViewById(R.id.ratingBar)
        authors = itemView.findViewById(R.id.auther)


    }
}


