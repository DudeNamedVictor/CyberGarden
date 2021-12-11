package com.example.cybergarden.presenter.rankedLists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cybergarden.data.RanketItems
import com.example.cybergarden.databinding.RankedListItemBinding

class RankedListAdapter(private val rankedItems: List<RanketItems>) :
    RecyclerView.Adapter<RankedListAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: RankedListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(news: List<RanketItems>, position: Int) {
            binding.apply {
                title.text = news[position].fio
                description.text = news[position].score
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RankedListItemBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(rankedItems, position)
    }

    override fun getItemCount() = rankedItems.size

}