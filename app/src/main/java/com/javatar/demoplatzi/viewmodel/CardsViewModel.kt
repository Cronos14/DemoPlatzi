package com.javatar.demoplatzi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.javatar.demoplatzi.CardItemUiState
import com.javatar.domain.models.Card
import com.javatar.domain.usecase.CardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val cardsUseCase: CardUseCase
) : ViewModel() {

    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    fun getCards() {
        viewModelScope.launch {
            _cards.value = cardsUseCase.getMonsterCards()
        }
    }

    val cardsUiStates = cardsUseCase.getCardsFlow()
        .map { pagingData ->
            pagingData.map {
                CardItemUiState(it)
            }
        }.cachedIn(viewModelScope)
}