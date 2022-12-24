package com.javatar.demoplatzi.adapter

import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.javatar.demoplatzi.databinding.ItemPagingFooterBinding

class FooterViewHolder(
    private val binding: ItemPagingFooterBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.btnRetry.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        with(binding) {
            val footerUiState = FooterUiState(loadState)
            progressBar.visibility = footerUiState.getLoadingVisibility()
            btnRetry.visibility = footerUiState.getErrorVisibility()
            tvError.visibility = footerUiState.getErrorVisibility()
            tvError.text = footerUiState.getErrorMessage(binding.root.context)
        }
    }
}

