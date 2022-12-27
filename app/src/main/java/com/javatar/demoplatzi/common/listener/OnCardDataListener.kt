package com.javatar.demoplatzi.common.listener

import com.javatar.demoplatzi.cardsexplorer.models.CardItemUiState

interface OnCardDataListener {
    fun getData(): CardItemUiState
}