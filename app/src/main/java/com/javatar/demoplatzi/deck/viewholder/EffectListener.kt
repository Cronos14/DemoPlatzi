package com.javatar.demoplatzi.deck.viewholder

import com.javatar.demoplatzi.common.component.TrapCardComponent
import com.javatar.demoplatzi.common.listener.ComponentListener

sealed interface EffectListener : ComponentListener {
    class TrapItemClickListener(val component: TrapCardComponent) : EffectListener
}