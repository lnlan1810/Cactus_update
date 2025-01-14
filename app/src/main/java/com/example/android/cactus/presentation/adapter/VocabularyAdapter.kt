package com.example.android.cactus.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.domain.model.Vocabulary
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.cactus.databinding.ItemVocabularyBinding
class VocabularyAdapter(
    private val items: List<Vocabulary?>,
    private val onPlaySoundClick: (Vocabulary) -> Unit
) : RecyclerView.Adapter<VocabularyAdapter.VocabularyViewHolder>() {

    inner class VocabularyViewHolder(val binding: ItemVocabularyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyViewHolder {
        val binding = ItemVocabularyBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VocabularyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VocabularyViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            if (item != null) {
                textWord.text = item.word
            }
            if (item != null) {
                textMeaning.text = item.meaning
            }
            if (item != null) {
                imageView.setImageResource(item.imageRes)
            }
            imageButton.setOnClickListener {
                if (item != null) {
                    onPlaySoundClick(item)
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
