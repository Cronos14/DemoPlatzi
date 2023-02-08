package com.javatar.demoplatzi.deck.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.listener.ComponentClickListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

class EmptyView : ViewHolderWrapper{
    override fun getViewHolder(root: ViewGroup): ComponentViewHolder {
        return EmptyViewHolder(
            LayoutInflater.from(root.context)
                .inflate(R.layout.item_empty, root, false)
        )
    }

    inner class EmptyViewHolder(itemView: View) :
        ComponentViewHolder(itemView) {
        override fun bind(
            component: Component,
            componentClickListener: ComponentClickListener?
        ) {

        }
    }
}