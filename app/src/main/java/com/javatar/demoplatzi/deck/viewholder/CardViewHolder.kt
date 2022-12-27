package com.javatar.demoplatzi.deck.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.cardsexplorer.models.CardItemUiState
import com.javatar.demoplatzi.databinding.ItemCardBinding

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