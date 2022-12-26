package com.javatar.domain.repository

import androidx.paging.PagingData
import com.javatar.domain.models.Card
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    fun getCards(name: String = ""): Flow<PagingData<Card>>
    suspend fun getMonsterCards(name: String = ""): List<MonsterCard>
    suspend fun getSpellCards(name: String = ""): List<SpellCard>
    suspend fun getTrapCards(name: String = ""): List<TrapCard>
}