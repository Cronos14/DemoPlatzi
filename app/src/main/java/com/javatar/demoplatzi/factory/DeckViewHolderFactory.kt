package com.javatar.demoplatzi.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.component.MonsterCardComponent
import com.javatar.demoplatzi.component.SpellCardComponent
import com.javatar.demoplatzi.component.TrapCardComponent
import com.javatar.demoplatzi.viewholder.*

class DeckViewHolderFactory : ComponentViewHolderFactory<DeckHolderListener> {
    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder<DeckHolderListener> {
        return when (viewType) {
            ItemType.MONSTER_CARD.type -> MonsterCardView().getViewHolder(parent)
            ItemType.SPELL_CARD.type -> SpellCardView().getViewHolder(parent)
            ItemType.TRAP_CARD.type -> TrapCardView().getViewHolder(parent)
            else -> EmptyView().getViewHolder(parent)
        }
    }

    override fun getViewType(component: Component): Int {
        return when (component) {
            is MonsterCardComponent -> ItemType.MONSTER_CARD.type
            is SpellCardComponent -> ItemType.SPELL_CARD.type
            is TrapCardComponent -> ItemType.TRAP_CARD.type
            else -> ItemType.NONE.type
        }
    }

    enum class ItemType(val type: Int) {
        NONE(0),
        MONSTER_CARD(1),
        SPELL_CARD(2),
        TRAP_CARD(3)
    }
}