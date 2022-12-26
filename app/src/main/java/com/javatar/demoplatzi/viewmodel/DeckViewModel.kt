package com.javatar.demoplatzi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.component.toComponent
import com.javatar.domain.models.*
import com.javatar.domain.usecase.DeckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeckViewModel @Inject constructor(
    private val deckUseCase: DeckUseCase
) : ViewModel() {

    private val _deck = MutableLiveData<List<Component>>()
    val deck: LiveData<List<Component>> = _deck

    fun getDeck() {
        viewModelScope.launch {
            _deck.value = deckUseCase.getCards().map {
                getTypeCard(it)
            }
        }
    }

    private fun getTypeCard(card: Card): Component {
        return when (card) {
            is MonsterCard -> card.toComponent()
            is SpellCard -> card.toComponent()
            is TrapCard -> card.toComponent()
            else -> card.toComponent()
        }
    }
}