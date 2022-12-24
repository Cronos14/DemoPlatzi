/*
 * Nissan MX Copyright
 * ComponentViewHolderFactory.kt
 * MyNissanApp Android
 * Created by jaive.torres on 6/21/21, 2:03 PM
 * Copyright © 6/21/21, 2:03 PM Globant. All rights reserved.
 */

package com.javatar.demoplatzi.factory

import android.view.ViewGroup
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.listener.ComponentListener
import com.javatar.demoplatzi.viewholder.ComponentViewHolder

interface ComponentViewHolderFactory<T : ComponentListener> {
    fun getViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder<T>
    fun getViewType(component: Component): Int
}