/*
 * Nissan MX Copyright
 * ComponentViewHolder.kt
 * MyNissanApp Android
 * Created by jaive.torres on 6/21/21, 2:03 PM
 * Copyright © 6/21/21, 2:03 PM Globant. All rights reserved.
 */

package com.javatar.demoplatzi.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.listener.ComponentClickListener
import com.javatar.demoplatzi.listener.ComponentListener

abstract class ComponentViewHolder<T : ComponentListener>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    abstract fun bind(component: Component, componentClickListener: ComponentClickListener<T>?)
}