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
import com.javatar.domain.models.SpellCard
import com.javatar.domain.value

@Entity(tableName = "spell_card")
data class SpellCardEntity(
    @PrimaryKey val id: String,
    val name: String,
    val type: String,
    val desc: String,
    val race: String,
    val idImage: String,
    val urlImage: String,
    val urlImageSmall: String,
    val archetype: String,
)

fun SpellCard.toEntity() = SpellCardEntity(
    id = id,
    name = name,
    type = type,
    desc = desc,
    race = race,
    idImage = images.firstOrNull()?.id.value(),
    urlImage = images.firstOrNull()?.url.value(),
    urlImageSmall = images.firstOrNull()?.urlSmall.value(),
    archetype = archetype,
)

fun SpellCardEntity.toModel() = SpellCard(
    id = id,
    name = name,
    type = type,
    desc = desc,
    race = race,
    images = listOf(Image(idImage, urlImage, urlImageSmall)),
    archetype = archetype,
)
