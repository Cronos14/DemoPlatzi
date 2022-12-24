package com.javatar.demoplatzi.component

import com.javatar.domain.models.MonsterCard
import com.javatar.domain.value

class MonsterCardComponent(
    val name: String,
    val description: String,
    val attack: Int,
    val defense: Int,
    val level: Int,
    val attribute: String,
    val type: String,
    val url: String,
    val urlSmall: String
) : Component

fun MonsterCard.toComponent() = MonsterCardComponent(
    name,
    desc,
    atk,
    def,
    level,
    attribute,
    type,
    images.firstOrNull()?.url.value(),
    images.firstOrNull()?.urlSmall.value()
)