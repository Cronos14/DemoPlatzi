package com.javatar.demoplatzi.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.component.MonsterCardComponent
import com.javatar.demoplatzi.databinding.ItemMonsterCardBinding
import com.javatar.demoplatzi.listener.ComponentClickListener

class MonsterCardView {

    lateinit var binding: ItemMonsterCardBinding

    fun getViewHolder(root: ViewGroup): ComponentViewHolder<DeckHolderListener> {
        val layoutInflater = LayoutInflater.from(root.context)
        binding = ItemMonsterCardBinding.inflate(layoutInflater, root, false)
        return ViewHolder(binding.root)
    }

    inner class ViewHolder(itemView: View) :
        ComponentViewHolder<DeckHolderListener>(itemView) {

        override fun bind(
            component: Component,
            componentClickListener: ComponentClickListener<DeckHolderListener>?,
        ) {
            val cardComponent = component as? MonsterCardComponent

            with(binding) {
                cardComponent?.let {
                    Glide.with(imageViewCard)
                        .load(it.urlSmall)
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(imageViewCard)
                    textViewName.text = it.name
                    textViewDescription.text = it.description
                    textViewAtk.text = it.attack.toString()
                    textViewDef.text = it.defense.toString()
                    componentClickListener?.onComponentClicked(
                        DeckHolderListener.GeneralItemClickListener(
                            it
                        )
                    )
                }
            }
        }
    }
}