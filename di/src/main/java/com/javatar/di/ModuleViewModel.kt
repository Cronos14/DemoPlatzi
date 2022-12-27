package com.javatar.di

import com.javatar.domain.cardexplorer.repository.CardRepository
import com.javatar.domain.deck.repository.DeckRepository
import com.javatar.domain.cardexplorer.usecase.CardUseCase
import com.javatar.domain.cardexplorer.usecase.CardUseCaseImp
import com.javatar.domain.deck.usecase.DeckUseCase
import com.javatar.domain.deck.usecase.DeckUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ModuleViewModel {

    @Provides
    @ViewModelScoped
    fun provideCardUseCase(cardRepository: CardRepository): CardUseCase {
        return CardUseCaseImp(cardRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeckUseCase(deckRepository: DeckRepository): DeckUseCase {
        return DeckUseCaseImp(deckRepository)
    }
}