package com.javatar.data.datasource.remote.response

import com.javatar.domain.models.MonsterCard
import com.javatar.domain.value

data class MonsterCardResponse(
    override val id: String?,
    override val name: String?,
    override val type: String?,
    override val desc: String?,
    override val race: String?,
    override val images: List<ImageResponse>?,
    override val archetype: String?,
    override val atk: Int?,
    override val def: Int?,
    override val level: Int?,
    override val attribute: String?
) : CardResponse(id, name, type, desc, race, images)

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

