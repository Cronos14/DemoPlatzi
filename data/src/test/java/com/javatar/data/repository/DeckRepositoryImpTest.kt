package com.javatar.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.javatar.data.dao.MonsterCardDao
import com.javatar.data.dao.SpellCardDao
import com.javatar.data.dao.TrapCardDao
import com.javatar.data.datasource.local.CardLocalDatasourceFacade
import com.javatar.data.datasource.local.MonsterCardLocalDataSource
import com.javatar.data.datasource.local.SpellCardLocalDataSource
import com.javatar.data.datasource.local.TrapCardLocalDataSource
import com.javatar.data.repository.utils.mocks.*
import com.javatar.demoplatzi.utils.CoroutinesTestRule
import com.javatar.demoplatzi.utils.mocks.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DeckRepositoryImpTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var monsterDao: MonsterCardDao

    @Mock
    private lateinit var spellCardDao: SpellCardDao

    @Mock
    private lateinit var trapCardDao: TrapCardDao

    @Mock
    private lateinit var monsterCardLocalDatasource: MonsterCardLocalDataSource

    @Mock
    private lateinit var spellCardLocalDatasource: SpellCardLocalDataSource

    @Mock
    private lateinit var trapCardLocalDatasource: TrapCardLocalDataSource

    private lateinit var cardLocalDatasourceFacade: CardLocalDatasourceFacade

    private lateinit var deckRepositoryImp: DeckRepositoryImp

    @Before
    fun setUp() {

        cardLocalDatasourceFacade = CardLocalDatasourceFacade(
            monsterCardLocalDatasource,
            spellCardLocalDatasource,
            trapCardLocalDatasource
        )
        deckRepositoryImp = DeckRepositoryImp(cardLocalDatasourceFacade)
    }

    @Test
    fun getCards() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(monsterCardLocalDatasource.getAll())
                .thenReturn(listOf(monsterCardEntityFake))
            Mockito.`when`(spellCardLocalDatasource.getAll())
                .thenReturn(listOf(spellCardEntityFake))
            Mockito.`when`(trapCardLocalDatasource.getAll()).thenReturn(listOf(trapCardEntityFake))

            val listCards = deckRepositoryImp.getCards()

            Mockito.verify(monsterCardLocalDatasource).getAll()
            Mockito.verify(spellCardLocalDatasource).getAll()
            Mockito.verify(trapCardLocalDatasource).getAll()

            assert(listCards.size == 3)

        }
    }

    @Test
    fun saveCard_monsterCard() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(monsterCardLocalDatasource.insert(any())).thenReturn(1L)

            val result = deckRepositoryImp.saveCard(monsterCardFake)

            Mockito.verify(monsterCardLocalDatasource).insert(monsterCardEntityFake)
            Mockito.verify(spellCardLocalDatasource, never()).insert(spellCardEntityFake)
            Mockito.verify(trapCardLocalDatasource, never()).insert(trapCardEntityFake)
        }
    }

    @Test
    fun saveCard_spellCard() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(spellCardLocalDatasource.insert(any())).thenReturn(1L)

            val result = deckRepositoryImp.saveCard(spellCardFake)

            Mockito.verify(monsterCardLocalDatasource, never()).insert(monsterCardEntityFake)
            Mockito.verify(spellCardLocalDatasource).insert(spellCardEntityFake)
            Mockito.verify(trapCardLocalDatasource, never()).insert(trapCardEntityFake)
        }
    }

    @Test
    fun saveCard_trapCard() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(trapCardLocalDatasource.insert(any())).thenReturn(1L)

            val result = deckRepositoryImp.saveCard(trapCardFake)

            Mockito.verify(monsterCardLocalDatasource, never()).insert(monsterCardEntityFake)
            Mockito.verify(spellCardLocalDatasource, never()).insert(spellCardEntityFake)
            Mockito.verify(trapCardLocalDatasource).insert(trapCardEntityFake)
        }
    }

    @Test
    fun saveCard_unknownCard() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            val result = deckRepositoryImp.saveCard(cardFake)

            Mockito.verify(monsterCardLocalDatasource, never()).insert(monsterCardEntityFake)
            Mockito.verify(spellCardLocalDatasource, never()).insert(spellCardEntityFake)
            Mockito.verify(trapCardLocalDatasource, never()).insert(trapCardEntityFake)
        }
    }

    @Test
    fun deleteCard_monsterCard() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(monsterCardLocalDatasource.delete(any())).thenReturn(null)

            val result = deckRepositoryImp.deleteCard(monsterCardFake)

            Mockito.verify(monsterCardLocalDatasource, ).delete(monsterCardEntityFake)
            Mockito.verify(spellCardLocalDatasource, never()).delete(spellCardEntityFake)
            Mockito.verify(trapCardLocalDatasource, never()).delete(trapCardEntityFake)
        }
    }

    @Test
    fun deleteCard_spellCard() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(spellCardLocalDatasource.delete(any())).thenReturn(null)

            val result = deckRepositoryImp.deleteCard(spellCardFake)

            Mockito.verify(monsterCardLocalDatasource, never()).delete(monsterCardEntityFake)
            Mockito.verify(spellCardLocalDatasource).delete(spellCardEntityFake)
            Mockito.verify(trapCardLocalDatasource, never()).delete(trapCardEntityFake)
        }
    }

    @Test
    fun deleteCard_trapCard() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(trapCardLocalDatasource.delete(any())).thenReturn(null)

            val result = deckRepositoryImp.deleteCard(trapCardFake)

            Mockito.verify(monsterCardLocalDatasource, never()).delete(monsterCardEntityFake)
            Mockito.verify(spellCardLocalDatasource, never()).delete(spellCardEntityFake)
            Mockito.verify(trapCardLocalDatasource).delete(trapCardEntityFake)
        }
    }

    @Test
    fun deleteCard_unknownCard() {
        coroutinesTestRule.testDispatcher.runBlockingTest {

            val result = deckRepositoryImp.deleteCard(cardFake)

            Mockito.verify(monsterCardLocalDatasource, never()).delete(monsterCardEntityFake)
            Mockito.verify(spellCardLocalDatasource, never()).delete(spellCardEntityFake)
            Mockito.verify(trapCardLocalDatasource, never()).delete(trapCardEntityFake)
        }
    }
}

fun <T> any(): T = Mockito.any<T>()
