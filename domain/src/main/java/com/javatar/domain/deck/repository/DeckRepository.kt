package com.javatar.domain.deck.repository

import com.javatar.domain.models.Card

interface DeckRepository {
    suspend fun saveCard(card: Card): Long
    suspend fun deleteCard(card: Card)
    suspend fun getCards(nameDeck: String = ""): List<Card>
}