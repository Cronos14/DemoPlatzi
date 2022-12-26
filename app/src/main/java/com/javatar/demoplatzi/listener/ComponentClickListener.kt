package com.javatar.demoplatzi.listener

interface ComponentClickListener<T : ComponentListener> {
    fun onComponentClicked(clicked: T)
}