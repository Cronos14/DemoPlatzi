package com.javatar.demoplatzi.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.javatar.demoplatzi.component.*
import com.javatar.demoplatzi.utils.CoroutinesTestRule
import com.javatar.demoplatzi.utils.mocks.*
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.usecase.DeckUseCase
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DeckViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var deckUseCase: DeckUseCase

    @Mock
    private lateinit var monsterCard: MonsterCard

    @Mock
    private lateinit var observer: Observer<List<Component>>

    @Captor
    private lateinit var argumentCaptorComponents: ArgumentCaptor<List<Component>>

    @Mock
    private lateinit var observerCancel: Observer<Void>

    @Captor
    private lateinit var argumentCaptorCancelComponents: ArgumentCaptor<Void>

    @InjectMocks
    private lateinit var viewModel: DeckViewModel

    @Test
    fun getDeck_getMonsterCard_success() {

        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(deckUseCase.getCards()).thenReturn(listOf(monsterCardFake))

            viewModel.deck.observeForever(observer)
            viewModel.getDeck()

            Mockito.verify(observer).onChanged(argumentCaptorComponents.capture())

            Mockito.verify(deckUseCase).getCards()

            val values: MutableList<List<Component>> = argumentCaptorComponents.allValues

            assertThat(monsterCardComponentFake, instanceOf(MonsterCardComponent::class.java))
            Assert.assertEquals(
                monsterCardComponentFake.name,
                (values[0][0] as MonsterCardComponent).name
            )
        }
    }

    @Test
    fun getDeck_getSpellCard_success() {

        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(deckUseCase.getCards()).thenReturn(listOf(spellCardFake))

            viewModel.deck.observeForever(observer)
            viewModel.getDeck()

            Mockito.verify(observer).onChanged(argumentCaptorComponents.capture())

            Mockito.verify(deckUseCase).getCards()

            val values: MutableList<List<Component>> = argumentCaptorComponents.allValues

            assertThat(spellCardComponentFake, instanceOf(SpellCardComponent::class.java))
            Assert.assertEquals(
                spellCardComponentFake.type,
                (values[0][0] as SpellCardComponent).type
            )
        }
    }

    @Test
    fun getDeck_getTrapCard_success() {

        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(deckUseCase.getCards()).thenReturn(listOf(trapCardFake))

            viewModel.deck.observeForever(observer)
            viewModel.getDeck()

            Mockito.verify(observer).onChanged(argumentCaptorComponents.capture())

            Mockito.verify(deckUseCase).getCards()

            val values: MutableList<List<Component>> = argumentCaptorComponents.allValues

            assertThat(trapCardComponentFake, instanceOf(TrapCardComponent::class.java))
            Assert.assertEquals(
                trapCardComponentFake.type,
                (values[0][0] as TrapCardComponent).type
            )
        }
    }

    @Test
    fun getDeck_getCard_success() {

        coroutinesTestRule.testDispatcher.runBlockingTest {

            Mockito.`when`(deckUseCase.getCards()).thenReturn(listOf(cardFake))

            viewModel.deck.observeForever(observer)
            viewModel.getDeck()

            Mockito.verify(observer).onChanged(argumentCaptorComponents.capture())

            Mockito.verify(deckUseCase).getCards()

            val values: MutableList<List<Component>> = argumentCaptorComponents.allValues

            assertThat(cardComponentFake, instanceOf(CardComponent::class.java))
            Assert.assertEquals(cardComponentFake.type, (values[0][0] as CardComponent).type)
        }
    }
}