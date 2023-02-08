package com.javatar.demoplatzi.deck.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.component.MonsterCardComponent
import com.javatar.demoplatzi.common.factory.DeckItemType
import com.javatar.demoplatzi.common.factory.DeckViewHolderFactory
import com.javatar.demoplatzi.common.listener.ComponentClickListener
import com.javatar.demoplatzi.common.listener.ComponentListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder
import com.javatar.demoplatzi.databinding.ItemMonsterCardBinding

class MonsterCardView : ViewHolderWrapper {

    lateinit var binding: ItemMonsterCardBinding

    override fun getViewHolder(root: ViewGroup): ComponentViewHolder {
        val layoutInflater = LayoutInflater.from(root.context)
        binding = ItemMonsterCardBinding.inflate(layoutInflater, root, false)
        return ViewHolder(binding.root)
    }

    inner class ViewHolder(itemView: View) :
        ComponentViewHolder(itemView) {

//        override fun bind(
//            component: Component,
//            componentClickListener: ComponentClickListener<DeckExtraListener>?,
//        ) {
//            val card = component as? MonsterCardComponent
//            with(binding) {
//                card?.let { card ->
//                    Glide.with(imageViewCard)
//                        .load(card.urlSmall)
//                        .diskCacheStrategy(DiskCacheStrategy.DATA)
//                        .into(imageViewCard)
//                    textViewName.text = card.name
//                    textViewDescription.text = card.description
//                    textViewAtk.text = card.attack.toString()
//                    textViewDef.text = card.defense.toString()
//                    root.setOnClickListener {
//                        componentClickListener?.onComponentClicked(
//                            DeckExtraListener.ExtraMonsterItemClickListener(
//                                card
//                            )
//                        )
//                    }
//                }
//            }
//        }

//        override fun <T : ComponentListener> bind(
//            component: Component,
//            componentClickListener: ComponentClickListener<T>?
//        ) {
//            val card = component as? MonsterCardComponent
//            with(binding) {
//                card?.let { card ->
//                    Glide.with(imageViewCard)
//                        .load(card.urlSmall)
//                        .diskCacheStrategy(DiskCacheStrategy.DATA)
//                        .into(imageViewCard)
//                    textViewName.text = card.name
//                    textViewDescription.text = card.description
//                    textViewAtk.text = card.attack.toString()
//                    textViewDef.text = card.defense.toString()
//                    root.setOnClickListener {
////                        componentClickListener?.onComponentClicked(
////                            DeckExtraListener.ExtraMonsterItemClickListener(
////                                card
////                            )
////                        )
//                    }
//                }
//            }
//        }

        override fun bind(component: Component, componentClickListener: ComponentClickListener?) {
            val card = component as? MonsterCardComponent
            with(binding) {
                card?.let { card ->
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
                            DeckExtraListener.ExtraMonsterItemClickListener(
                                card
                            )
                        )
                    }
                }
            }
        }
    }
}