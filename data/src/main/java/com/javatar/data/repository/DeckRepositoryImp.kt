package com.javatar.data.repository

import com.javatar.data.datasource.local.CardLocalDatasourceFacade
import com.javatar.data.datasource.local.card.toEntity
import com.javatar.data.datasource.local.card.toModel
import com.javatar.domain.models.Card
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard
import com.javatar.domain.repository.DeckRepository

class DeckRepositoryImp(
    private val cardLocalDatasourceFacade: CardLocalDatasourceFacade
) : DeckRepository {

    override suspend fun saveCard(card: Card): Long {
        return when (card) {
            is MonsterCard -> cardLocalDatasourceFacade.monsterCardLocalDatasource.insert(card.toEntity())
            is SpellCard -> cardLocalDatasourceFacade.spellCardLocalDatasource.insert(card.toEntity())
            is TrapCard -> cardLocalDatasourceFacade.trapCardLocalDatasource.insert(card.toEntity())
            else -> return -1
        }
    }

    override suspend fun deleteCard(card: Card) {
        return when (card) {
            is MonsterCard -> cardLocalDatasourceFacade.monsterCardLocalDatasource.delete(card.toEntity())
            is SpellCard -> cardLocalDatasourceFacade.spellCardLocalDatasource.delete(card.toEntity())
            is TrapCard -> cardLocalDatasourceFacade.trapCardLocalDatasource.delete(card.toEntity())
            else -> return
        }
    }

    override suspend fun getCards(nameDeck: String): List<Card> {
        val list = mutableListOf<Card>()
        list.addAll(getMonsterCards())
        list.addAll(getSpellCards())
        list.addAll(getTrapCards())
        return list
    }

    private suspend fun getMonsterCards(): List<Card> {
        return cardLocalDatasourceFacade.monsterCardLocalDatasource.getAll().map {
            it.toModel()
        }
    }

    private suspend fun getSpellCards(): List<Card> {
        return cardLocalDatasourceFacade.spellCardLocalDatasource.getAll().map {
            it.toModel()
        }
    }

    private suspend fun getTrapCards(): List<Card> {
        return cardLocalDatasourceFacade.trapCardLocalDatasource.getAll().map {
            it.toModel()
        }
    }
}
