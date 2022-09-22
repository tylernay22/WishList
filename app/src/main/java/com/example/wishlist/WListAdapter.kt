package com.example.wishlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WListAdapter(private val wlists: List<WList>) : RecyclerView.Adapter<WListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView


        init{
            nameTextView = itemView.findViewById(R.id.tvItem)
            priceTextView = itemView.findViewById(R.id.tvPrice)
            urlTextView = itemView.findViewById(R.id.tvUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(contactView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val list = wlists.get(position)

        holder.nameTextView.text = list.name
        holder.priceTextView.text = list.price
        holder.urlTextView.text = list.url
    }

    override fun getItemCount(): Int {
        return wlists.size
    }
}