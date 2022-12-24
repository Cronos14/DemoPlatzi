package com.javatar.demoplatzi

import com.javatar.domain.models.Card


data class CardItemUiState(private val card: Card) : BaseUiState() {
    fun getImageUrl() = card.images.firstOrNull()?.url
    fun getName() = card.name
}