package com.javatar.demoplatzi.common.component

import com.javatar.domain.models.Card
import com.javatar.domain.value

class CardComponent(
    val id: String,
    val name: String,
    val type: String,
    val desc: String,
    val race: String,
    val url: String,
    val urlSmall: String,
) : Component

fun Card.toComponent() = CardComponent(
    id,
    name,
    type,
    desc,
    race,
    images.firstOrNull()?.url.value(),
    images.firstOrNull()?.urlSmall.value(),
)