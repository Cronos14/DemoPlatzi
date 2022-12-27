package com.javatar.demoplatzi.cardsexplorer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.javatar.demoplatzi.cardsexplorer.models.CardItemUiState
import com.javatar.domain.cardexplorer.usecase.CardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val cardsUseCase: CardUseCase
) : ViewModel() {

    fun getCards() = cardsUseCase.getCards()
        .map { pagingData ->
            pagingData.map {
                CardItemUiState(it)
            }
        }.cachedIn(viewModelScope)

}