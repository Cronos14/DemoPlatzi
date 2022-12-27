package com.javatar.di

import com.javatar.data.dao.MonsterCardDao
import com.javatar.data.dao.SpellCardDao
import com.javatar.data.dao.TrapCardDao
import com.javatar.data.datasource.RemoteDataSource
import com.javatar.data.datasource.local.CardLocalDatasourceFacade
import com.javatar.data.datasource.local.MonsterCardLocalDataSource
import com.javatar.data.datasource.local.SpellCardLocalDataSource
import com.javatar.data.datasource.local.TrapCardLocalDataSource
import com.javatar.data.repository.CardRepositoryImp
import com.javatar.data.repository.DeckRepositoryImp
import com.javatar.domain.cardexplorer.repository.CardRepository
import com.javatar.domain.deck.repository.DeckRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object ModuleUseCase {
    @Provides
    fun provideCardRepository(remoteDataSource: RemoteDataSource): CardRepository {
        return CardRepositoryImp(remoteDataSource)
    }

    @Provides
    fun provideDeckRepository(
        cardLocalDatasourceFacade: CardLocalDatasourceFacade,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): DeckRepository {
        return DeckRepositoryImp(cardLocalDatasourceFacade, dispatcher)
    }

    @Provides
    fun provideCardLocalDatasourceFacade(
        monsterCardLocalDataSource: MonsterCardLocalDataSource,
        spellCardLocalDataSource: SpellCardLocalDataSource,
        trapCardLocalDataSource: TrapCardLocalDataSource
    ): CardLocalDatasourceFacade {
        return CardLocalDatasourceFacade(
            monsterCardLocalDataSource,
            spellCardLocalDataSource,
            trapCardLocalDataSource
        )
    }

    @Provides
    fun provideMonsterCardLocalDataSource(monsterCardDao: MonsterCardDao): MonsterCardLocalDataSource {
        return MonsterCardLocalDataSource(monsterCardDao)
    }

    @Provides
    fun provideSpellCardLocalDataSource(spellCardDao: SpellCardDao): SpellCardLocalDataSource {
        return SpellCardLocalDataSource(spellCardDao)
    }

    @Provides
    fun provideTrapCardLocalDataSource(trapCardDao: TrapCardDao): TrapCardLocalDataSource {
        return TrapCardLocalDataSource(trapCardDao)
    }
}