package com.example.cybergarden.presenter.directionOfTraining

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cybergarden.data.DoubleItem
import com.example.cybergarden.databinding.DirectionItemLayoutBinding

class DirectionAdapter(private val news: List<DoubleItem>) :
    RecyclerView.Adapter<DirectionAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: DirectionItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(news: List<DoubleItem>, position: Int) {
            binding.apply {
                title.text = news[position].programDto.name
                code.text = news[position].programDto.code
                if (news[position].percent != "") {
                    percent.visibility = View.VISIBLE
                    percent.text = "Вероятность поступления: " + news[position].percent
                }
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