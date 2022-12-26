package com.javatar.demoplatzi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javatar.domain.models.Card
import com.javatar.domain.usecase.DeckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardDetailViewModel @Inject constructor(
    private val deckUseCase: DeckUseCase
) : ViewModel() {

    fun saveCard(card: Card) {
        viewModelScope.launch {
            deckUseCase.saveCard(card)
        }
    }

    fun deleteCard(card: Card) {
        viewModelScope.launch {
            deckUseCase.deleteCard(card)
        }
    }
}