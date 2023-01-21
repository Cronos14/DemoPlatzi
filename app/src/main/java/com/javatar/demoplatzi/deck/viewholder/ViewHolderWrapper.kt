package com.javatar.demoplatzi.deck.viewholder

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.listener.ComponentListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

interface ViewHolderWrapper<T : ComponentListener> {
    fun getViewHolder(root: ViewGroup): ComponentViewHolder<T>
}