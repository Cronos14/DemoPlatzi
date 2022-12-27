package com.javatar.demoplatzi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.component.toComponent
import com.javatar.domain.error.Empty
import com.javatar.domain.models.Card
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.models.SpellCard
import com.javatar.domain.models.TrapCard
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

    private val _empty = MutableLiveData<Void?>()
    val empty: LiveData<Void?> = _empty

    fun getDeck() {
        viewModelScope.launch {
            val result = deckUseCase.getCards()
            result.fold(
                {
                    when (it) {
                        is Empty -> _empty.value = null
                    }
                },
                { cards ->
                    _deck.value = cards.map { card ->
                        getTypeCard(card)
                    }
                }
            )
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