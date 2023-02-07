package com.javatar.demoplatzi.common.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.component.MonsterCardComponent
import com.javatar.demoplatzi.common.component.SpellCardComponent
import com.javatar.demoplatzi.common.component.TrapCardComponent
import com.javatar.demoplatzi.common.listener.ComponentListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder
import com.javatar.demoplatzi.deck.viewholder.*

class DeckViewHolderFactory : ComponentViewHolderFactory<DeckHolderListener> {
    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder<DeckHolderListener> {
        return when (viewType) {
            DeckItemType.MONSTER_CARD.type -> MonsterCardView().getViewHolder(parent)
            DeckItemType.SPELL_CARD.type -> SpellCardView().getViewHolder(parent)
            DeckItemType.TRAP_CARD.type -> TrapCardView().getViewHolder(parent)
            else -> EmptyView().getViewHolder(parent)
        }
    }

    override fun getViewType(component: Component): Int {
        return when (component) {
            is MonsterCardComponent -> DeckItemType.MONSTER_CARD.type
            is SpellCardComponent -> DeckItemType.SPELL_CARD.type
            is TrapCardComponent -> DeckItemType.TRAP_CARD.type
            else -> DeckItemType.NONE.type
        }
    }
}