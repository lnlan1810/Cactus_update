package com.example.android.cactus.presentation.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.android.cactus.databinding.ItemMonthBinding
import com.example.android.cactus.domain.model.Month
/*

class MonthHolder (private val binding: ItemMonthBinding,
                   private  val glide: RequestManager,
                   private  val action: (Int) -> Unit): RecyclerView.ViewHolder(binding.root) {

    private  var monthItem: Month? = null

    init{
        itemView.setOnClickListener{
            monthItem?.id?.also(action)
        }
    }

    fun bind(item: Month){
        monthItem = item

        with(binding){
            tvWord.text = item.title

            glide.load(item.url).into(imageView2)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            action: (Int)-> Unit
        ) = MonthHolder(
            ItemMonthBinding.inflate(
                LayoutInflater
                    .from(parent.context),
                parent,
                false
            ),
            glide,
            action
        )
    }
}*/
