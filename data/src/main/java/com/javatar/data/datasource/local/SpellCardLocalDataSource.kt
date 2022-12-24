/*
 * Nissan MX Copyright
 * VehicleLocalDataSource.kt
 * MyNissanApp Android
 * Created by raultadeo.gonzalez on 10/02/22 0:13
 * Copyright © 10/02/22 0:13 Globant. All rights reserved.
 */

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

    override suspend fun delete(id: String) {
        dao.delete(id)
    }

    override suspend fun delete(element: SpellCardEntity) {
        dao.delete(element)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}