package com.javatar.demoplatzi.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.CardItemUiState
import com.javatar.demoplatzi.databinding.ItemCardBinding

class CardViewHolder(private val binding: ItemCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(cardItemUiState: CardItemUiState) {
        with(binding) {
            Glide.with(imageViewCard)
                .load(cardItemUiState.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageViewCard)
        }
    }
}