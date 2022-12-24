/*
 * Nissan MX Copyright
 * VehicleEntity.kt
 * MyNissanApp Android
 * Created by raultadeo.gonzalez on 07/12/21 14:27
 * Copyright © 07/12/21 14:27 Globant. All rights reserved.
 */

package com.javatar.data.datasource.local.card

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.javatar.domain.models.Image
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.value

@Entity(tableName = "monster_card")
data class MonsterCardEntity(
    @PrimaryKey val id: String,
    val name: String,
    val type: String,
    val desc: String,
    val race: String,
    val idImage: String,
    val urlImage: String,
    val urlImageSmall: String,
    val archetype: String,
    val atk: Int,
    val def: Int,
    val level: Int,
    val attribute: String
)

fun MonsterCard.toEntity() = MonsterCardEntity(
    id = id,
    name = name,
    type = type,
    desc = desc,
    race = race,
    idImage = images.firstOrNull()?.id.value(),
    urlImage = images.firstOrNull()?.url.value(),
    urlImageSmall = images.firstOrNull()?.urlSmall.value(),
    archetype = archetype,
    atk = atk,
    def = def,
    level = level,
    attribute = attribute
)

fun MonsterCardEntity.toModel() = MonsterCard(
    id = id,
    name = name,
    type = type,
    desc = desc,
    race = race,
    images = listOf(Image(idImage, urlImage, urlImageSmall)),
    archetype = archetype,
    atk = atk,
    def = def,
    level = level,
    attribute = attribute
)
