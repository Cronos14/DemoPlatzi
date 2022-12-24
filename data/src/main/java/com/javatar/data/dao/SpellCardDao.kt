package com.javatar.data.dao

import androidx.room.*
import com.javatar.data.datasource.local.card.MonsterCardEntity
import com.javatar.data.datasource.local.card.SpellCardEntity

@Dao
interface SpellCardDao {
    @Query("SELECT * FROM spell_card WHERE id   = (:id)")
    suspend fun get(id: String): SpellCardEntity?

    @Query("SELECT * FROM spell_card")
    suspend fun getAll(): List<SpellCardEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: SpellCardEntity): Long

    @Delete
    fun delete(entity: SpellCardEntity)

    @Query("DELETE FROM spell_card WHERE id = (:id)")
    fun delete(id: String)

    @Query("DELETE FROM spell_card")
    suspend fun deleteAll()

    @Update
    fun update(entity: SpellCardEntity)
}