package com.javatar.demoplatzi.deck.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.common.component.MonsterCardComponent
import com.javatar.demoplatzi.common.listener.ComponentClickListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder
import com.javatar.demoplatzi.databinding.ItemMonsterCardBinding

class MonsterCardView : ViewHolderWrapper<DeckHolderListener, MonsterCardComponent> {

    lateinit var binding: ItemMonsterCardBinding

    override fun getViewHolder(root: ViewGroup): ComponentViewHolder<DeckHolderListener, MonsterCardComponent> {
        val layoutInflater = LayoutInflater.from(root.context)
        binding = ItemMonsterCardBinding.inflate(layoutInflater, root, false)
        return ViewHolder(binding.root)
    }

    inner class ViewHolder(itemView: View) :
        ComponentViewHolder<DeckHolderListener, MonsterCardComponent>(itemView) {

        override fun bind(
            component: MonsterCardComponent,
            componentClickListener: ComponentClickListener<DeckHolderListener>?,
        ) {

            with(binding) {
                component.let { card ->
                    Glide.with(imageViewCard)
                        .load(card.urlSmall)
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(imageViewCard)
                    textViewName.text = card.name
                    textViewDescription.text = card.description
                    textViewAtk.text = card.attack.toString()
                    textViewDef.text = card.defense.toString()
                    root.setOnClickListener {
                        componentClickListener?.onComponentClicked(
                            DeckHolderListener.GeneralItemClickListener(
                                card
                            )
                        )
                    }
                }
            }
        }
    }
}