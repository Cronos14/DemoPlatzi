package com.javatar.demoplatzi.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.CardItemUiState
import com.javatar.demoplatzi.databinding.ItemCardBinding
import com.javatar.domain.models.Card

class CardViewHolder(
    private val binding: ItemCardBinding,
    private val onCardClick: (card: CardItemUiState) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(cardItemUiState: CardItemUiState) {
        binding.root.setOnClickListener { onCardClick.invoke(cardItemUiState) }
        with(binding) {
            Glide.with(imageViewCard)
                .load(cardItemUiState.getImageSmallUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageViewCard)
        }
    }
}