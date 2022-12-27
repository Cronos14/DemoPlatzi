package com.javatar.demoplatzi.cardsexplorer.models

import com.javatar.domain.models.Card
import com.javatar.domain.value


data class CardItemUiState(var card: Card? = null) : BaseUiState() {
    fun getImageUrl() = card?.images?.firstOrNull()?.url.value()
    fun getImageSmallUrl() = card?.images?.firstOrNull()?.urlSmall.value()
    fun getName() = card?.name.value()
    fun getDescription() = card?.desc.value()
}