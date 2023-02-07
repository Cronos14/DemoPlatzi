package com.javatar.demoplatzi.common.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.listener.ComponentListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

interface ComponentViewHolderFactory<out T : ComponentListener> {
    fun getViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder<T>
    fun getViewType(component: Component) = component.type()
}