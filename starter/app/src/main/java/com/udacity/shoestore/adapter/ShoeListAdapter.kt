package com.udacity.shoestore.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeListAdapter(private val list: List<Shoe>) : RecyclerView.Adapter<ShoeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ShoeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe: Shoe = list[position]
        holder.bind(shoe)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}


class ShoeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var title: TextView? = null
    private var desc: TextView? = null


    init {
        title = itemView.findViewById(R.id.shoeTitle)
        desc = itemView.findViewById(R.id.shoeDesc)
    }

    @SuppressLint("SetTextI18n")
    fun bind(shoe: Shoe) {
        title?.text = shoe.name
        desc?.text = shoe.company + ", " + shoe.size +", " + shoe.description
    }
}