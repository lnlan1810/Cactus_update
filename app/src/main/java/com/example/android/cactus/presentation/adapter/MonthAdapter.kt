package com.example.android.cactus.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.android.cactus.databinding.ItemMonthBinding
import com.example.android.cactus.domain.model.Month
class MonthAdapter(
    private val data: List<Month>,
    private val onVolumeClick: (Month) -> Unit
) : RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    class MonthViewHolder(val binding: ItemMonthBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val binding = ItemMonthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        val item = data[position]
        with(holder.binding) {
            tvWord.text = item.title
            tvText.text = item.meaning
            imageButton.setOnClickListener {
                onVolumeClick(item)
            }
        }
    }

    override fun getItemCount(): Int = data.size
}
