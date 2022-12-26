package com.javatar.data.datasource.local

import com.javatar.data.dao.SpellCardDao
import com.javatar.data.datasource.local.card.SpellCardEntity

class SpellCardLocalDataSource(
    private val dao: SpellCardDao
) : LocalDataSource<SpellCardEntity> {
    override suspend fun get(id: String): SpellCardEntity? {
        return dao.get(id)
    }

    override suspend fun getAll(): List<SpellCardEntity> {
        return dao.getAll()
    }

    override suspend fun insert(element: SpellCardEntity): Long {
        return dao.insert(element)
    }

    override suspend fun update(element: SpellCardEntity) {
        dao.update(element)
    }

    override suspend fun delete(element: SpellCardEntity) {
        dao.delete(element)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}