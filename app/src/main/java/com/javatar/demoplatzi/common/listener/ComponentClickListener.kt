package com.javatar.demoplatzi.common.listener

interface ComponentClickListener<in T : ComponentListener> {
    fun onComponentClicked(clicked: T)
}