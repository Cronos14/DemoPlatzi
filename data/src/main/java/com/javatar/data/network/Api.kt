package com.javatar.data.network

import com.javatar.data.datasource.remote.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("api/v7/cardinfo.php")
    suspend fun getCards(
        @Query("fname") name: String?,
        @Query("offset") offset: Int?,
        @Query("num") num: Int?
    ): Response<GeneralResponse<CardResponse>>

    @GET("api/v7/cardinfo.php")
    suspend fun getMonsterCards(
        @Query("fname") name: String? = "",
        @Query("offset") offset: Int?,
        @Query("num") num: Int?,
        @Query("type") type: String? = "Effect Monster,Normal Monster"
    ): Response<GeneralResponse<MonsterCardResponse>>

    @GET("api/v7/cardinfo.php")
    suspend fun getSpellCards(
        @Query("fname") name: String? = "",
        @Query("offset") offset: Int?,
        @Query("num") num: Int?,
        @Query("type") type: String? = "Spell card"
    ): Response<GeneralResponse<SpellCardResponse>>

    @GET("api/v7/cardinfo.php")
    suspend fun getTrapCards(
        @Query("fname") name: String? = "",
        @Query("offset") offset: Int?,
        @Query("num") num: Int?,
        @Query("type") type: String? = "Trap card"
    ): Response<GeneralResponse<TrapCardResponse>>
}