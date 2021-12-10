package com.example.cybergarden.presenter.newsFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cybergarden.R

class NewsAdapter(private val names: List<String>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null
        var description: TextView? = null
        var date: TextView? = null
        var image: ImageView? = null

        init {
            title = itemView.findViewById(R.id.title)
            description = itemView.findViewById(R.id.description)
            date = itemView.findViewById(R.id.date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title?.text = names[position]
        holder.description?.text = "кот"
        holder.date?.text = "12.12.2012"
    }

    override fun getItemCount() = names.size

}
