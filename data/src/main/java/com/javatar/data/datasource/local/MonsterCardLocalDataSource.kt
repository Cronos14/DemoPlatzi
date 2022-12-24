/*
 * Nissan MX Copyright
 * VehicleLocalDataSource.kt
 * MyNissanApp Android
 * Created by raultadeo.gonzalez on 10/02/22 0:13
 * Copyright © 10/02/22 0:13 Globant. All rights reserved.
 */

package com.javatar.data.datasource.local

import com.javatar.data.dao.MonsterCardDao
import com.javatar.data.datasource.local.card.MonsterCardEntity

class MonsterCardLocalDataSource(
    private val dao: MonsterCardDao
) : LocalDataSource<MonsterCardEntity> {
    override suspend fun get(id: String): MonsterCardEntity? {
        return dao.get(id)
    }

    override suspend fun getAll(): List<MonsterCardEntity> {
        return dao.getAll()
    }

    override suspend fun insert(element: MonsterCardEntity): Long {
        return dao.insert(element)
    }

    override suspend fun update(element: MonsterCardEntity) {
        dao.update(element)
    }

    override suspend fun delete(id: String) {
        dao.delete(id)
    }

    override suspend fun delete(element: MonsterCardEntity) {
        dao.delete(element)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}