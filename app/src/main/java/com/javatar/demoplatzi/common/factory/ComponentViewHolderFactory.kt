package com.javatar.demoplatzi.common.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

interface ComponentViewHolderFactory {
    fun getViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder
    fun getViewType(component: Component) = component.type()
}