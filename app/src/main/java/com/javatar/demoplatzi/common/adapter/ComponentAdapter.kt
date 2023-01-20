package com.javatar.demoplatzi.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.factory.ComponentViewHolderFactory
import com.javatar.demoplatzi.common.listener.ComponentClickListener
import com.javatar.demoplatzi.common.listener.ComponentListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

open class ComponentAdapter<T : ComponentListener, C: Component>(
    private val componentViewHolderFactory: ComponentViewHolderFactory<T, C>,
    val components: ArrayList<C>,
    private val componentClickListener: ComponentClickListener<T>? = null
) :
    RecyclerView.Adapter<ComponentViewHolder<T, C>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder<T, C> {
        return componentViewHolderFactory.getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder<T, C>, position: Int) {
        return holder.bind(components[position], componentClickListener)
    }

    override fun getItemCount(): Int {
        return components.size
    }

    override fun getItemViewType(position: Int): Int {
        return componentViewHolderFactory.getViewType(components[position])
    }
}