package com.javatar.demoplatzi.deck.viewholder

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

interface ViewHolderWrapper {
    fun getViewHolder(root: ViewGroup): ComponentViewHolder
    private inline fun <reified T> getViewType(component: Component): Boolean {
        if(component is T) {
            return true
        }
        return false
    }
}

abstract class ViewHolderWrapperAbs {
    abstract fun getViewHolder(root: ViewGroup): ComponentViewHolder
    abstract fun getViewTypeCustom(component: Component): Boolean
    protected inline fun <reified T : Any> getViewType(component: Component) = component is T
}