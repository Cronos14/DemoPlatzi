package com.javatar.domain.deck.usecase

import com.javatar.domain.common.Either
import com.javatar.domain.error.CardError
import com.javatar.domain.error.Empty
import com.javatar.domain.models.Card
import com.javatar.domain.deck.repository.DeckRepository
import com.javatar.domain.deck.usecase.DeckUseCase

class DeckUseCaseImp(
    private val deckRepository: DeckRepository
) : DeckUseCase {
    override suspend fun saveCard(card: Card) = deckRepository.saveCard(card)
    override suspend fun deleteCard(card: Card) = deckRepository.deleteCard(card)
    override suspend fun getCards(nameDeck: String): Either<CardError, List<Card>> =
        if (deckRepository.getCards()
                .isEmpty()
        ) Either.Left(Empty()) else Either.Right(deckRepository.getCards())

}