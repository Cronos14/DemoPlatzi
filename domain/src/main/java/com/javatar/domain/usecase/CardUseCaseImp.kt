package com.javatar.domain.usecase

import com.javatar.domain.repository.CardRepository

class CardUseCaseImp(
    private val cardRepository: CardRepository
) : CardUseCase {
    override suspend fun getCards() = cardRepository.getCards()
    override fun getCardsFlow() = cardRepository.getCardsFlow()
    override suspend fun getMonsterCards() = cardRepository.getMonsterCards()
    override suspend fun getSpellCards() = cardRepository.getSpellCards()
    override suspend fun getTrapCards() = cardRepository.getTrapCards()
}