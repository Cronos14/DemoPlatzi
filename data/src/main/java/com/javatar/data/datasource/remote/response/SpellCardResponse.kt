package com.javatar.data.datasource.remote.response

import com.javatar.domain.models.SpellCard
import com.javatar.domain.value

data class SpellCardResponse(
    override val id: String?,
    override val name: String?,
    override val type: String?,
    override val desc: String?,
    override val race: String?,
    override val images: List<ImageResponse>?,
    override val archetype: String?,
) : CardResponse(id, name, type, desc, race, images)

fun SpellCardResponse.toSpellCard() = SpellCard(
    id = id.value(),
    name = name.value(),
    type = type.value(),
    desc = desc.value(),
    race = race.value(),
    images = images?.map { it.toImage() } ?: emptyList(),
    archetype = archetype.value(),
)

