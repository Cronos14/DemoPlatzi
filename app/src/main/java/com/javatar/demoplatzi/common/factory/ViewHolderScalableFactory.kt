package com.javatar.demoplatzi.common.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder
import com.javatar.demoplatzi.deck.viewholder.ViewHolderWrapper

class ViewHolderScalableFactory(
    private val viewHoldersMap: LinkedHashMap<Int, ViewHolderWrapper>
) : ComponentViewHolderFactory {

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder {
        viewHoldersMap[viewType]?.let {
            return (it.getViewHolder(parent))
        }
        return viewHoldersMap.values.first().getViewHolder(parent)
    }
}