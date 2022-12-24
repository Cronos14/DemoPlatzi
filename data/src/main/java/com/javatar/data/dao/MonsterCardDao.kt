package com.javatar.data.dao

import androidx.room.*
import com.javatar.data.datasource.local.card.MonsterCardEntity

@Dao
interface MonsterCardDao {
    @Query("SELECT * FROM monster_card WHERE id   = (:id)")
    suspend fun get(id: String): MonsterCardEntity?

    @Query("SELECT * FROM monster_card")
    suspend fun getAll(): List<MonsterCardEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: MonsterCardEntity): Long

    @Delete
    fun delete(entity: MonsterCardEntity)

    @Query("DELETE FROM monster_card WHERE id = (:id)")
    fun delete(id: String)

    @Query("DELETE FROM monster_card")
    suspend fun deleteAll()

    @Update
    fun update(entity: MonsterCardEntity)
}