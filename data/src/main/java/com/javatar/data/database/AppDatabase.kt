package com.javatar.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.javatar.data.dao.MonsterCardDao
import com.javatar.data.dao.SpellCardDao
import com.javatar.data.dao.TrapCardDao
import com.javatar.data.datasource.local.card.MonsterCardEntity
import com.javatar.data.datasource.local.card.SpellCardEntity
import com.javatar.data.datasource.local.card.TrapCardEntity

@Database(
    entities = [MonsterCardEntity::class, SpellCardEntity::class, TrapCardEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun monsterCardDao(): MonsterCardDao
    abstract fun spellCardDao(): SpellCardDao
    abstract fun trapCardDao(): TrapCardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private const val PERSISTENT_DATA_BASE = "persistentDataBase"

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    PERSISTENT_DATA_BASE
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}