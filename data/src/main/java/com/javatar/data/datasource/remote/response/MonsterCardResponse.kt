package com.javatar.data.datasource.remote.response

import com.javatar.domain.models.MonsterCard
import com.javatar.domain.value

data class MonsterCardResponse(
    val archetype: String?,
    val atk: Int?,
    val def: Int?,
    val level: Int?,
    val attribute: String?
) : CardResponse()

fun MonsterCardResponse.toMonsterCard() = MonsterCard(
    id = id.value(),
    name = name.value(),
    type = type.value(),
    desc = desc.value(),
    race = race.value(),
    images = images?.map { it.toImage() } ?: emptyList(),
    archetype = archetype.value(),
    atk = atk.value(),
    def = def.value(),
    level = level.value(),
    attribute = attribute.value()
)

