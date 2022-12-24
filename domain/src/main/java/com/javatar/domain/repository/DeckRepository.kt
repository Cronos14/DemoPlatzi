package com.javatar.domain.repository

import com.javatar.domain.models.Card
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard

interface DeckRepository {
    suspend fun saveMonsterCard(card: MonsterCard)
    suspend fun saveSpellCard(card: SpellCard)
    suspend fun saveTrapCard(card: TrapCard)
    suspend fun getCards(nameDeck: String = ""): List<Card>
}