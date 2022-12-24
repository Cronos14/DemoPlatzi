package com.javatar.demoplatzi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javatar.domain.models.Card
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard
import com.javatar.domain.usecase.DeckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardDetailViewModel @Inject constructor(
    private val deckUseCase: DeckUseCase
) : ViewModel() {

    fun saveCard(card: Card) {
        saveByType(card)
    }

    private fun saveCard(card: MonsterCard) {
        viewModelScope.launch {
            deckUseCase.saveMonsterCard(card)
        }
    }

    private fun saveCard(card: SpellCard) {
        viewModelScope.launch {
            deckUseCase.saveSpellCard(card)
        }
    }

    private fun saveCard(card: TrapCard) {
        viewModelScope.launch {
            deckUseCase.saveTrapCard(card)
        }
    }

    private fun saveByType(card: Card) {
        return when (card) {
            is MonsterCard -> saveCard(card)
            is SpellCard -> saveCard(card)
            is TrapCard -> saveCard(card)
            else -> return
        }
    }
}