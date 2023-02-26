package com.javatar.demoplatzi.common.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder
import com.javatar.demoplatzi.deck.viewholder.ViewHolderWrapperAbs

class ViewHolderFactory(
//    private val viewHolders: List<Pair<Class<*>,ViewHolderWrapperAbs>>,
    private val viewHolders: List<ViewHolderWrapperAbs>,
) : ComponentViewHolderFactory {

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder {
        return viewHolders[viewType].getViewHolder(parent)
    }

    override fun getViewType(component: Component): Int {
        viewHolders.forEachIndexed { index, pair ->
            if (pair.getViewTypeCustom(component)) {
                return index
            }
        }
        return -1
    }
}