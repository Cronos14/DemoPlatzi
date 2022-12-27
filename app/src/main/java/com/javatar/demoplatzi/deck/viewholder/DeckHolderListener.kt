package com.javatar.demoplatzi.deck.viewholder

import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.listener.ComponentListener

sealed class DeckHolderListener : ComponentListener {
    class GeneralItemClickListener(val component: Component) : DeckHolderListener()
}