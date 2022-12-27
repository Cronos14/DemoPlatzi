package com.javatar.demoplatzi.common.listener

interface ComponentClickListener<T : ComponentListener> {
    fun onComponentClicked(clicked: T)
}