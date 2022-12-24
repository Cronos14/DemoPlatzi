package com.javatar.demoplatzi.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.factory.ComponentViewHolderFactory
import com.javatar.demoplatzi.listener.ComponentClickListener
import com.javatar.demoplatzi.listener.ComponentListener
import com.javatar.demoplatzi.viewholder.ComponentViewHolder

open class ComponentAdapter<T : ComponentListener>(
    private val componentViewHolderFactory: ComponentViewHolderFactory<T>,
    val components: ArrayList<Component>,
    private val componentClickListener: ComponentClickListener<T>? = null
) :
    RecyclerView.Adapter<ComponentViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder<T> {
        return componentViewHolderFactory.getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder<T>, position: Int) {
        return holder.bind(components[position], componentClickListener)
    }

    override fun getItemCount(): Int {
        return components.size
    }

    override fun getItemViewType(position: Int): Int {
        return componentViewHolderFactory.getViewType(components[position])
    }
}