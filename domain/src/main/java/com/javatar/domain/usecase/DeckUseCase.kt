package com.javatar.domain.usecase

import com.javatar.domain.common.Either
import com.javatar.domain.error.CardError
import com.javatar.domain.models.Card

interface DeckUseCase {
    suspend fun saveCard(card: Card): Long
    suspend fun deleteCard(card: Card)
    suspend fun getCards(nameDeck: String = ""): Either<CardError, List<Card>>
}