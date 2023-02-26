package com.javatar.demoplatzi.deck.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.component.SpellCardComponent
import com.javatar.demoplatzi.common.component.TrapCardComponent
import com.javatar.demoplatzi.common.listener.ComponentClickListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder
import com.javatar.demoplatzi.databinding.ItemTrapCardBinding
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard

class TrapCardView : ViewHolderWrapperAbs() {

    override fun getViewHolder(root: ViewGroup): ComponentViewHolder {
        return ViewHolder(
            ItemTrapCardBinding.inflate(
                LayoutInflater.from(root.context),
                root,
                false
            )
        )
    }

    override fun getViewTypeCustom(component: Component): Boolean {
        return getViewType<TrapCardComponent>(component)
    }

    inner class ViewHolder(private val itemBinding: ItemTrapCardBinding) :
        ComponentViewHolder(itemBinding.root) {

        override fun bind(
            component: Component,
            componentClickListener: ComponentClickListener?,
        ) {
            val card = component as? TrapCardComponent
            with(itemBinding) {
                card?.let { card ->
                    Glide.with(imageViewCard)
                        .load(card.urlSmall)
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(imageViewCard)
                    textViewName.text = card.name
                    textViewDescription.text = card.desc
                    root.setOnClickListener {
                        componentClickListener?.onComponentClicked(
                            EffectListener.TrapItemClickListener(
                                card
                            )
                        )
                    }
                }
            }
        }
    }
}