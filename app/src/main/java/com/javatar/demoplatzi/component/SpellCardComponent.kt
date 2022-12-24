package com.javatar.demoplatzi.component

import com.javatar.domain.models.SpellCard
import com.javatar.domain.value

class SpellCardComponent(
    val id: String,
    val name: String,
    val type: String,
    val desc: String,
    val race: String,
    val url: String,
    val urlSmall: String,
    val archetype: String,
) : Component

fun SpellCard.toComponent() = SpellCardComponent(
    id,
    name,
    type,
    desc,
    race,
    images.firstOrNull()?.url.value(),
    images.firstOrNull()?.urlSmall.value(),
    archetype
)