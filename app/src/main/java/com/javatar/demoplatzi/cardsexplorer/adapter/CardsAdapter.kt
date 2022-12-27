package com.javatar.demoplatzi.cardsexplorer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.javatar.demoplatzi.cardsexplorer.models.CardItemUiState
import com.javatar.demoplatzi.databinding.ItemCardBinding
import com.javatar.demoplatzi.cardsexplorer.viewholder.CardViewHolder

class CardsAdapter constructor(
    private val onCardClick: (card: CardItemUiState) -> Unit
) :
    PagingDataAdapter<CardItemUiState, CardViewHolder>(Comparator) {

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        getItem(position)?.let { cardItemUiState -> holder.bind(cardItemUiState) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            return CardViewHolder(this, onCardClick)
        }
    }

    object Comparator : DiffUtil.ItemCallback<CardItemUiState>() {
        override fun areItemsTheSame(oldItem: CardItemUiState, newItem: CardItemUiState): Boolean {
            return oldItem.getName() == newItem.getName()
        }

        override fun areContentsTheSame(
            oldItem: CardItemUiState,
            newItem: CardItemUiState
        ): Boolean {
            return oldItem == newItem
        }
    }

}