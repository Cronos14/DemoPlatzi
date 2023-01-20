package com.javatar.demoplatzi.common.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.listener.ComponentClickListener
import com.javatar.demoplatzi.common.listener.ComponentListener

abstract class ComponentViewHolder<T : ComponentListener, C: Component>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    abstract fun bind(component: C, componentClickListener: ComponentClickListener<T>?)
}