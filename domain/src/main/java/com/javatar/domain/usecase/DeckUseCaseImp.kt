package com.javatar.domain.usecase

import com.javatar.domain.models.MonsterCard
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard
import com.javatar.domain.repository.DeckRepository

class DeckUseCaseImp(
    private val deckRepository: DeckRepository
) : DeckUseCase {
    override suspend fun saveMonsterCard(card: MonsterCard) = deckRepository.saveMonsterCard(card)
    override suspend fun saveSpellCard(card: SpellCard) = deckRepository.saveSpellCard(card)
    override suspend fun saveTrapCard(card: TrapCard) = deckRepository.saveTrapCard(card)
    override suspend fun getCards(nameDeck: String) = deckRepository.getCards(nameDeck)
}