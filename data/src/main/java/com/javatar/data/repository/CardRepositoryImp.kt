package com.javatar.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.javatar.data.datasource.RemoteDataSource
import com.javatar.data.datasource.local.CardLocalDatasourceFacade
import com.javatar.data.datasource.local.LocalDataSource
import com.javatar.data.datasource.remote.response.toCard
import com.javatar.data.datasource.remote.response.toMonsterCard
import com.javatar.data.datasource.remote.response.toSpellCard
import com.javatar.data.datasource.remote.response.toTrapCard
import com.javatar.data.pagingdatasource.CardPagingDataSource
import com.javatar.domain.models.Card
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard
import com.javatar.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class CardRepositoryImp(
    private val remoteDataSource: RemoteDataSource,
) : CardRepository {
    override suspend fun getCards(name: String): List<Card> {
        val result = remoteDataSource.api.getCards(
            name,
            0,
            5
        )
        return result.body()?.data?.map {
            it.toCard()
        } ?: emptyList()
    }

    override fun getCardsFlow(name: String): Flow<PagingData<Card>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = { CardPagingDataSource(remoteDataSource.api) }
        ).flow
    }

    override suspend fun getMonsterCards(name: String): List<MonsterCard> {
        val result = remoteDataSource.api.getMonsterCards(
            name,
            0,
            5
        )
        return result.body()?.data?.map {
            it.toMonsterCard()
        } ?: emptyList()
    }

    override suspend fun getSpellCards(name: String): List<SpellCard> {
        val result = remoteDataSource.api.getSpellCards(
            name,
            0,
            5
        )
        return result.body()?.data?.map {
            it.toSpellCard()
        } ?: emptyList()
    }

    override suspend fun getTrapCards(name: String): List<TrapCard> {
        val result = remoteDataSource.api.getTrapCards(
            name,
            0,
            5
        )
        return result.body()?.data?.map {
            it.toTrapCard()
        } ?: emptyList()
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}
