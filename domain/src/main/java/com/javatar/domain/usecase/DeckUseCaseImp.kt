package com.javatar.domain.usecase

import com.javatar.domain.models.Card
import com.javatar.domain.repository.DeckRepository

class DeckUseCaseImp(
    private val deckRepository: DeckRepository
) : DeckUseCase {
    override suspend fun saveCard(card: Card) = deckRepository.saveCard(card)
    override suspend fun deleteCard(card: Card) = deckRepository.deleteCard(card)
    override suspend fun getCards(nameDeck: String) = deckRepository.getCards(nameDeck)
}