/*
 * Nissan MX Copyright
 * LocalDataSource.kt
 * MyNissanApp Android
 * Created by raultadeo.gonzalez on 10/02/22 0:07
 * Copyright © 10/02/22 0:07 Globant. All rights reserved.
 */

package com.javatar.data.datasource.local

interface LocalDataSource<T> {
    suspend fun get(id: String): T?
    suspend fun getAll(): List<T>
    suspend fun insert(element: T): Long
    suspend fun update(element: T)
    suspend fun delete(id: String)
    suspend fun delete(element: T)
    suspend fun deleteAll()
}