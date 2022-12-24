/*
 * Nissan MX Copyright
 * EmptyView.kt
 * MyNissanApp Android
 * Created by jaive.torres on 9/10/21, 4:25 PM
 * Copyright © 9/10/21, 4:25 PM Globant. All rights reserved. (e
 */

package com.javatar.demoplatzi.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.listener.ComponentClickListener

class EmptyView {
    fun getViewHolder(root: ViewGroup): ComponentViewHolder<DeckHolderListener> {
        return EmptyViewHolder(
            LayoutInflater.from(root.context)
                .inflate(R.layout.item_empty, root, false)
        )
    }

    inner class EmptyViewHolder(itemView: View) :
        ComponentViewHolder<DeckHolderListener>(itemView) {
        override fun bind(
            component: Component,
            componentClickListener: ComponentClickListener<DeckHolderListener>?
        ) {

        }
    }
}