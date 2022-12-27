package com.javatar.demoplatzi.common.component

import com.javatar.domain.models.Image
import com.javatar.domain.models.MonsterCard
import com.javatar.domain.value

class MonsterCardComponent(
    val id: String,
    val name: String,
    val description: String,
    val attack: Int,
    val defense: Int,
    val level: Int,
    val attribute: String,
    val type: String,
    val idUrl: String,
    val url: String,
    val urlSmall: String,
    val race: String,
    val archetype: String,
) : Component

fun MonsterCard.toComponent() = MonsterCardComponent(
    id = id,
    name = name,
    description = desc,
    attack = atk,
    defense = def,
    level = level,
    attribute = attribute,
    type = type,
    idUrl = images.firstOrNull()?.id.value(),
    url = images.firstOrNull()?.url.value(),
    urlSmall = images.firstOrNull()?.urlSmall.value(),
    race = race,
    archetype = archetype,
)

fun MonsterCardComponent.toCard() = MonsterCard(
    id = id.value(),
    name = name.value(),
    type = type.value(),
    desc = description.value(),
    race = race.value(),
    images = listOf(Image(idUrl, url, urlSmall)),
    archetype = archetype.value(),
    atk = attack.value(),
    def = defense.value(),
    level = level.value(),
    attribute = attribute.value()
)