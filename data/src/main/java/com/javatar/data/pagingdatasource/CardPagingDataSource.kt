package com.javatar.data.pagingdatasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.javatar.data.datasource.remote.response.*
import com.javatar.data.network.Api
import com.javatar.domain.models.Card

class CardPagingDataSource(
    private val api: Api
) : PagingSource<Int, Card>() {
    override fun getRefreshKey(state: PagingState<Int, Card>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Card> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val results = params.loadSize
            val response = api.getCards(offset = page * results, num = results)
            val result = response.body()?.data?.map {
                getCardType(it)
            } ?: emptyList()
            LoadResult.Page(
                data = result,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (result.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    private fun getCardType(cardResponse: CardResponse) = when {
        cardResponse.type?.contains(
            TYPE_MONSTER,
            true
        ) == true -> cardResponse.toMonsterResponse().toMonsterCard()
        cardResponse.type.equals(
            TYPE_SPELL,
            true
        ) -> cardResponse.toSpellResponse().toSpellCard()
        cardResponse.type.equals(
            TYPE_TRAP,
            true
        ) -> cardResponse.toTrapResponse().toTrapCard()
        else -> cardResponse.toCard()
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
        const val TYPE_MONSTER = "Monster"
        const val TYPE_SPELL = "Spell Card"
        const val TYPE_TRAP = "Trap Card"
    }
}