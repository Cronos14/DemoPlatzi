package com.javatar.di

import com.javatar.domain.repository.CardRepository
import com.javatar.domain.usecase.CardUseCase
import com.javatar.domain.usecase.CardUseCaseImp
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
}