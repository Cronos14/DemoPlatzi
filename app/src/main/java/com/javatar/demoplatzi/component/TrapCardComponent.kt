package com.javatar.demoplatzi.component

import com.javatar.domain.models.TrapCard
import com.javatar.domain.value

class TrapCardComponent(
    val id: String,
    val name: String,
    val type: String,
    val desc: String,
    val race: String,
    val url: String,
    val urlSmall: String,
) : Component

fun TrapCard.toComponent() = TrapCardComponent(
    id,
    name,
    type,
    desc,
    race,
    images.firstOrNull()?.url.value(),
    images.firstOrNull()?.urlSmall.value(),
)