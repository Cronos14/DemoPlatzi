package com.javatar.demoplatzi.deck.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.component.SpellCardComponent
import com.javatar.demoplatzi.common.component.TrapCardComponent
import com.javatar.demoplatzi.common.factory.DeckViewHolderFactory
import com.javatar.demoplatzi.databinding.ItemSpellCardBinding
import com.javatar.demoplatzi.common.listener.ComponentClickListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

class SpellCardView : ViewHolderWrapper{

    lateinit var binding: ItemSpellCardBinding

    override fun getViewHolder(root: ViewGroup): ComponentViewHolder {
        val layoutInflater = LayoutInflater.from(root.context)
        binding = ItemSpellCardBinding.inflate(layoutInflater, root, false)
        return ViewHolder(binding.root)
    }

    inner class ViewHolder(itemView: View) :
        ComponentViewHolder(itemView) {

        override fun bind(
            component: Component,
            componentClickListener: ComponentClickListener?,
        ) {
            val card = component as? SpellCardComponent
            with(binding) {
                card?.let { card ->
                    Glide.with(imageViewCard)
                        .load(card.urlSmall)
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(imageViewCard)
                    textViewName.text = card.name
                    textViewDescription.text = card.desc
                    root.setOnClickListener {
                        componentClickListener?.onComponentClicked(
                            DeckHolderListener.SpellItemClickListener(
                                card
                            )
                        )
                    }
                }
            }
        }
    }
}