package com.javatar.data.dao

import androidx.room.*
import com.javatar.data.datasource.local.card.TrapCardEntity

@Dao
interface TrapCardDao {
    @Query("SELECT * FROM trap_card WHERE id   = (:id)")
    suspend fun get(id: String): TrapCardEntity?

    @Query("SELECT * FROM trap_card")
    suspend fun getAll(): List<TrapCardEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: TrapCardEntity): Long

    @Delete
    fun delete(entity: TrapCardEntity)

    @Query("DELETE FROM trap_card WHERE id = (:id)")
    fun delete(id: String)

    @Query("DELETE FROM trap_card")
    suspend fun deleteAll()

    @Update
    fun update(entity: TrapCardEntity)
}