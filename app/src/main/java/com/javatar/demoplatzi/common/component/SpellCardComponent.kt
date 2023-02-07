package com.javatar.demoplatzi.common.component

import com.javatar.demoplatzi.common.factory.DeckItemType
import com.javatar.demoplatzi.common.factory.DeckViewHolderFactory
import com.javatar.domain.models.Image
import com.javatar.domain.models.SpellCard
import com.javatar.domain.value

class SpellCardComponent(
    val id: String,
    val name: String,
    val type: String,
    val desc: String,
    val race: String,
    val idUrl: String,
    val url: String,
    val urlSmall: String,
    val archetype: String,
) : Component {
    override fun type(): Int {
        return DeckItemType.SPELL_CARD.type
    }
}

fun SpellCard.toComponent() = SpellCardComponent(
    id,
    name,
    type,
    desc,
    race,
    images.firstOrNull()?.id.value(),
    images.firstOrNull()?.url.value(),
    images.firstOrNull()?.urlSmall.value(),
    archetype
)

fun SpellCardComponent.toCard() = SpellCard(
    id = id.value(),
    name = name.value(),
    type = type.value(),
    desc = desc.value(),
    race = race.value(),
    images = listOf(Image(idUrl, url, urlSmall)),
    archetype = archetype.value(),
)