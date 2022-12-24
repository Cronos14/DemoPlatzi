/*
 * Nissan MX Copyright
 * VehicleLocalDataSource.kt
 * MyNissanApp Android
 * Created by raultadeo.gonzalez on 10/02/22 0:13
 * Copyright © 10/02/22 0:13 Globant. All rights reserved.
 */

package com.javatar.data.datasource.local

import com.javatar.data.dao.TrapCardDao
import com.javatar.data.datasource.local.card.TrapCardEntity

class TrapCardLocalDataSource(
    private val dao: TrapCardDao
) : LocalDataSource<TrapCardEntity> {
    override suspend fun get(id: String): TrapCardEntity? {
        return dao.get(id)
    }

    override suspend fun getAll(): List<TrapCardEntity> {
        return dao.getAll()
    }

    override suspend fun insert(element: TrapCardEntity): Long {
        return dao.insert(element)
    }

    override suspend fun update(element: TrapCardEntity) {
        dao.update(element)
    }

    override suspend fun delete(id: String) {
        dao.delete(id)
    }

    override suspend fun delete(element: TrapCardEntity) {
        dao.delete(element)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}