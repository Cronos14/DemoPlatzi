package com.javatar.di

import android.content.Context
import com.javatar.data.dao.MonsterCardDao
import com.javatar.data.dao.SpellCardDao
import com.javatar.data.dao.TrapCardDao
import com.javatar.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleDatabase {
    @Provides
    fun provideMonsterCardDao(appDatabase: AppDatabase): MonsterCardDao {
        return appDatabase.monsterCardDao()
    }

    @Provides
    fun provideSpellCardDao(appDatabase: AppDatabase): SpellCardDao {
        return appDatabase.spellCardDao()
    }

    @Provides
    fun provideTrapCardDao(appDatabase: AppDatabase): TrapCardDao {
        return appDatabase.trapCardDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(appContext)
    }
}