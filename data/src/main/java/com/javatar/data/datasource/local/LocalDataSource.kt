package com.javatar.data.datasource.local

interface LocalDataSource<T> {
    suspend fun get(id: String): T?
    suspend fun getAll(): List<T>
    suspend fun insert(element: T): Long
    suspend fun update(element: T)
    suspend fun delete(element: T)
    suspend fun deleteAll()
}