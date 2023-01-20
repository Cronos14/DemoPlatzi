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
//    private val viewHolders: Map<Int, Pair<Class<*>,ViewHolderWrapper<T, C>>>,
//    private val viewHolders2: List<Pair<Class<C>,ViewHolderWrapper<T, C>>>,
    private val viewHolders2: ViewHolderWrapper<T, C>,
    private val viewHolders3: ViewHolderWrapper<T, C>,
) : ComponentViewHolderFactory<T, C> {

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder<T, C> {

//        viewHolders2.forEachIndexed { index, pair ->
//            if (index == viewType) {
//                return pair.second.getViewHolder(parent)
//            }
//        }
////        viewHolders.map {
////            if (it.key == viewType) {
////                return it.value.second.getViewHolder(parent)
////            }
////        }
//
////        return emptyHolder.getViewHolder(parent)
////        return viewHolders.values.first().second.getViewHolder(parent)
//        return viewHolders2.first().second.getViewHolder(parent)
        return viewHolders2.getViewHolder(parent)
    }

    override fun getViewType(component: C): Int {

//        viewHolders.keys.map {
//            if(component.javaClass.name == viewHolders[it]?.first?.name) {
//                return it
//            }
//        }

//        viewHolders2.forEachIndexed { index, pair ->
//            if (component.javaClass.name == pair.first.name) {
//                return index
//            }
//        }

        return -1
    }
}