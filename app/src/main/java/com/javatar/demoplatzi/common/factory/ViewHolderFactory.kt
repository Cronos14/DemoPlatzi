package com.javatar.demoplatzi.common.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.component.MonsterCardComponent
import com.javatar.demoplatzi.common.component.SpellCardComponent
import com.javatar.demoplatzi.common.component.TrapCardComponent
import com.javatar.demoplatzi.common.listener.ComponentListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder
import com.javatar.demoplatzi.deck.viewholder.*

class ViewHolderFactory<T : ComponentListener, C: Component>(
    private val viewHolders: List<Pair<Class<C>,ViewHolderWrapper<T, C>>>,
) : ComponentViewHolderFactory<T, C> {

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder<T, C> {

        viewHolders.forEachIndexed { index, pair ->
            if (index == viewType) {
                return pair.second.getViewHolder(parent)
            }
        }
//
//        return emptyHolder.getViewHolder(parent)
        return viewHolders.first().second.getViewHolder(parent)
    }

    override fun getViewType(component: C): Int {
        viewHolders.forEachIndexed { index, pair ->
            if (component.javaClass.name == pair.first.name) {
                return index
            }
        }

        return -1
    }
}