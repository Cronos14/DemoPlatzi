package com.javatar.domain.cardexplorer.usecase

import androidx.paging.PagingData
import com.javatar.domain.models.Card
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard
import kotlinx.coroutines.flow.Flow

interface CardUseCase {
    fun getCards(): Flow<PagingData<Card>>
    suspend fun getMonsterCards(): List<MonsterCard>
    suspend fun getSpellCards(): List<SpellCard>
    suspend fun getTrapCards(): List<TrapCard>
}