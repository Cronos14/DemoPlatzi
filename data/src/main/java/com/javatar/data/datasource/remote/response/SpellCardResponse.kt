package com.javatar.data.datasource.remote.response

import com.javatar.domain.models.SpellCard
import com.javatar.domain.value

data class SpellCardResponse(
    val archetype: String?,
) : CardResponse()

fun SpellCardResponse.toSpellCard() = SpellCard(
    id = id.value(),
    name = name.value(),
    type = type.value(),
    desc = desc.value(),
    race = race.value(),
    images = images?.map { it.toImage() } ?: emptyList(),
    archetype = archetype.value(),
)

