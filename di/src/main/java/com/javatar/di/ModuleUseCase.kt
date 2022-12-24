package com.javatar.di

import com.javatar.data.datasource.RemoteDataSource
import com.javatar.data.repository.CardRepositoryImp
import com.javatar.domain.repository.CardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ModuleUseCase {
    @Provides
    fun provideCardRepository(remoteDataSource: RemoteDataSource): CardRepository {
        return CardRepositoryImp(remoteDataSource)
    }
}