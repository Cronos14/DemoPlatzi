package com.javatar.demoplatzi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.javatar.demoplatzi.databinding.ItemPagingFooterBinding
import com.javatar.demoplatzi.viewholder.FooterViewHolder

class FooterAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<FooterViewHolder>() {
    override fun onBindViewHolder(holder: FooterViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): FooterViewHolder {
        ItemPagingFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            return FooterViewHolder(this, retry)
        }
    }

}

