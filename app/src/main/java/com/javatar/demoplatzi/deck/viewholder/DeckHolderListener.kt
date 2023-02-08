package com.javatar.demoplatzi.deck.viewholder

import com.javatar.demoplatzi.common.component.MonsterCardComponent
import com.javatar.demoplatzi.common.component.SpellCardComponent
import com.javatar.demoplatzi.common.component.TrapCardComponent
import com.javatar.demoplatzi.common.listener.ComponentListener

sealed interface DeckHolderListener : ComponentListener {
    class MonsterItemClickListener(val component: MonsterCardComponent) : DeckHolderListener
    class SpellItemClickListener(val component: SpellCardComponent) : DeckHolderListener
//    class TrapItemClickListener(val component: TrapCardComponent) : DeckHolderListener
}

sealed interface DeckOther : DeckHolderListener {
    class OtherMonsterItemClickListener(val component: MonsterCardComponent) : DeckOther
}

sealed interface DeckExtraListener : DeckOther{
    class ExtraMonsterItemClickListener(val component: MonsterCardComponent) : DeckExtraListener
}