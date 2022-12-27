package com.javatar.demoplatzi.cardsexplorer.viewholder

import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.javatar.demoplatzi.cardsexplorer.models.FooterUiState
import com.javatar.demoplatzi.databinding.ItemPagingFooterBinding

class FooterViewHolder(
    private val binding: ItemPagingFooterBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.buttonRetry.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        with(binding) {
            val footerUiState = FooterUiState(loadState)
            progressBar.visibility = footerUiState.getLoadingVisibility()
            buttonRetry.visibility = footerUiState.getErrorVisibility()
            tvError.visibility = footerUiState.getErrorVisibility()
            tvError.text = footerUiState.getErrorMessage(binding.root.context)
        }
    }
}

