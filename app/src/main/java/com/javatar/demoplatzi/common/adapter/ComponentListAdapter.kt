package com.javatar.demoplatzi.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javatar.demoplatzi.common.component.Component
import com.javatar.demoplatzi.common.factory.ComponentViewHolderFactory
import com.javatar.demoplatzi.common.listener.ComponentClickListener
import com.javatar.demoplatzi.common.listener.ComponentListener
import com.javatar.demoplatzi.common.viewholder.ComponentViewHolder

open class ComponentListAdapter<T : ComponentListener>(
    private val componentViewHolderFactory: ComponentViewHolderFactory<T>,
    val components: ArrayList<Component>,
    private val componentClickListener: ComponentClickListener<T>? = null
) :
    ListAdapter<Component, ComponentViewHolder<T>>(ComponentDiffCallback()) {

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

    private class ComponentDiffCallback : DiffUtil.ItemCallback<Component>() {
        override fun areItemsTheSame(oldItem: Component, newItem: Component) = oldItem.equals(newItem)

        override fun areContentsTheSame(oldItem: Component, newItem: Component) = oldItem.equals(newItem)

    }
}