package com.example.android.cactus.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.R
import com.example.android.cactus.databinding.ItemVocabularyCategoryBinding
import com.example.android.cactus.domain.model.Vocabulary
import com.example.android.cactus.domain.model.VocabularyCategory

class VocabularyCategoryAdapter(
    private val categories: List<VocabularyCategory?>,
    private val onPlaySoundClick: (Vocabulary) -> Unit
) : RecyclerView.Adapter<VocabularyCategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val binding: ItemVocabularyCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemVocabularyCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        // Gán tiêu đề và nghĩa
        if (category != null) {
            holder.binding.textCategoryTitle.text = category.title
        }
        if (category != null) {
            holder.binding.textCategoryMeaning.text = category.meaning
        }

        // Lấy màu từ danh sách dựa trên vị trí
        val colorResId = categoryColors[position % categoryColors.size] // Lặp lại nếu hết màu
        val color = ContextCompat.getColor(holder.itemView.context, colorResId)

        // Đặt màu nền cho CardView
        holder.binding.cardView.setCardBackgroundColor(color)

        with(holder.binding) {
            if (category != null) {
                textCategoryTitle.text = category.title
            }
            if (category != null) {
                textCategoryMeaning.text = category.meaning
            }

            recyclerViewVocabulary.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                if (category != null) {
                    adapter = VocabularyAdapter(category.items, onPlaySoundClick)
                }
            }
        }
    }

    override fun getItemCount(): Int = categories.size
}

val categoryColors = listOf(
    R.color.categoryColor1,
    R.color.categoryColor2,
    R.color.categoryColor3,
    R.color.categoryColor4,
)
