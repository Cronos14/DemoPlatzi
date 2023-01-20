package com.javatar.demoplatzi.common.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.listener.ComponentListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

interface ComponentViewHolderFactory<T : ComponentListener, C: Component> {
    fun getViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder<T, C>
    fun getViewType(component: C): Int
}