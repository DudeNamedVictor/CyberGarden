package com.example.cybergarden.presenter.newsFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cybergarden.databinding.NewsItemBinding

class NewsAdapter(private val names: List<String>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(names: List<String>, position: Int) {
            binding.apply {
                title.text = names[position]
                description.text = "кот"
                date.text = "12.12.2012"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(names, position)
    }

    override fun getItemCount() = names.size

}
