package com.javatar.demoplatzi.common.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder
import com.javatar.demoplatzi.deck.viewholder.DeckHolderListener
import com.javatar.demoplatzi.deck.viewholder.ViewHolderWrapper

class ViewHolderScalableFactory(
    private val viewHoldersMap: LinkedHashMap<Int, ViewHolderWrapper<DeckHolderListener>>
) : ComponentViewHolderFactory<DeckHolderListener> {

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder<DeckHolderListener> {
        // is necessary instance the class
        viewHoldersMap[viewType]?.let {
            return (it.javaClass.newInstance().getViewHolder(parent))
        }
        return viewHoldersMap.values.first().javaClass.newInstance().getViewHolder(parent)
    }
}