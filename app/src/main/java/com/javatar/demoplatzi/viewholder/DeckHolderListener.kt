package com.javatar.demoplatzi.viewholder

import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.listener.ComponentListener

sealed class DeckHolderListener : ComponentListener {
    class GeneralItemClickListener(val component: Component) : DeckHolderListener()
}