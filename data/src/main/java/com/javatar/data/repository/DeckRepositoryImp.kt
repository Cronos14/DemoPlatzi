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
    override suspend fun saveMonsterCard(card: MonsterCard) {
        cardLocalDatasourceFacade.monsterCardLocalDatasource.insert(card.toEntity())
    }

    override suspend fun saveSpellCard(card: SpellCard) {
        cardLocalDatasourceFacade.spellCardLocalDatasource.insert(card.toEntity())
    }

    override suspend fun saveTrapCard(card: TrapCard) {
        cardLocalDatasourceFacade.trapCardLocalDatasource.insert(card.toEntity())
    }

    override suspend fun getCards(name: String): List<Card> {
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
