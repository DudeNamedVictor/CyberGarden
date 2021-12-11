package com.example.cybergarden.presenter.directionOfTraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cybergarden.data.Direction
import com.example.cybergarden.databinding.DirectionItemLayoutBinding

class DirectionAdapter(private val news: List<Direction>) :
    RecyclerView.Adapter<DirectionAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: DirectionItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(news: List<Direction>, position: Int) {
            binding.apply {
                title.text = news[position].name
                code.text = news[position].code
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DirectionItemLayoutBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(news, position)
    }

    override fun getItemCount() = news.size
}